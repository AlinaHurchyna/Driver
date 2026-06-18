package alina.hurchyna.ah.driver.service;

import alina.hurchyna.ah.driver.model.RideRequest;
import alina.hurchyna.ah.driver.model.RideStatus;
import alina.hurchyna.ah.driver.repository.RideRequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RideServiceTest {

    @Mock
    private RideRequestRepository rideRequestRepository;

    @InjectMocks
    private RideService rideService;

    private RideRequest pendingRide;

    @BeforeEach
    void setUp() {
        pendingRide = new RideRequest();
        pendingRide.setStartLocation("Wrzeszcz, Gdańsk");
        pendingRide.setDestination("Stare Miasto, Gdańsk");
        pendingRide.setStatus(RideStatus.PENDING);
        pendingRide.setClientUsername("alina");
    }

    @Test
    void requestRide_shouldSetStatusToPendingAndSave() {
        RideRequest ride = new RideRequest();
        ride.setStartLocation("Oliwa, Gdańsk");
        ride.setDestination("Gdańsk Główny");

        when(rideRequestRepository.save(any())).thenReturn(ride);

        rideService.requestRide(ride);

        assertThat(ride.getStatus()).isEqualTo(RideStatus.PENDING);
        verify(rideRequestRepository, times(1)).save(ride);
    }

    @Test
    void acceptRide_shouldSetStatusToAcceptedAndSaveDriverUsername() {
        pendingRide.setStatus(RideStatus.PENDING);
        when(rideRequestRepository.findById(1L)).thenReturn(Optional.of(pendingRide));
        when(rideRequestRepository.save(any())).thenReturn(pendingRide);

        RideRequest result = rideService.acceptRide(1L, "driver99");

        assertThat(result.getStatus()).isEqualTo(RideStatus.ACCEPTED);
        assertThat(result.getDriverUsername()).isEqualTo("driver99");
        verify(rideRequestRepository).save(pendingRide);
    }

    @Test
    void completeRide_shouldSetStatusToCompleted() {
        pendingRide.setStatus(RideStatus.IN_PROGRESS);
        when(rideRequestRepository.findById(2L)).thenReturn(Optional.of(pendingRide));
        when(rideRequestRepository.save(any())).thenReturn(pendingRide);

        RideRequest result = rideService.completeRide(2L);

        assertThat(result.getStatus()).isEqualTo(RideStatus.COMPLETED);
    }

    @Test
    void getAvailableRides_shouldReturnOnlyPendingRides() {
        when(rideRequestRepository.findByStatus(RideStatus.PENDING)).thenReturn(List.of(pendingRide));

        List<RideRequest> result = rideService.getAvailableRides();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(RideStatus.PENDING);
    }

    @Test
    void acceptRide_withNonExistentId_shouldReturnNull() {
        when(rideRequestRepository.findById(999L)).thenReturn(Optional.empty());

        RideRequest result = rideService.acceptRide(999L, "driver");

        assertThat(result).isNull();
        verify(rideRequestRepository, never()).save(any());
    }
}
