# 🚗 Driver — Ride Booking Web Application

A full-stack web application for ride booking, built with Spring Boot and a custom dark UI inspired by Uber. The app supports two user roles — **client** and **driver** — with separate dashboards, real-time GPS tracking, Google Maps navigation, and ride history.

## Live Demo

**[driver-production-5b5f.up.railway.app](https://driver-production-5b5f.up.railway.app)**

Deployed on Railway with PostgreSQL database.

---

## ✨ Features

### 👤 Client Side
- Register and log in as a client
- Book a ride by entering a pickup address and destination
- **GPS auto-detection** — automatically fills the "From" field using the browser's geolocation API and reverse geocoding via Nominatim (OpenStreetMap)
- Interactive map (Leaflet.js + OpenStreetMap) with a live pulsing blue location dot
- Address autocomplete powered by Nominatim API
- Visual route line drawn between pickup and destination markers
- **Live ride status banner** — polls every 5 seconds and shows when a driver has accepted the order
- Ride history page in dark Uber-style design

### 🚘 Driver Side
- Register and log in as a driver
- Uber-style driver dashboard with map, live orange GPS dot, online/offline toggle, stats cards (earnings, rating)
- **Available rides page** — see pending client orders with pickup and destination, accept with one click
- Each ride card shows a **"Navigate to Client"** button that opens Google Maps with the client's pickup address
- After accepting, the driver is taken to a **3-phase navigation page**:
  1. **Phase 1 — Going to client**: button to open Google Maps to pickup location, button to confirm client has boarded
  2. **Phase 2 — En route**: navigation switches to destination, button to complete the ride
  3. **Phase 3 — Done**: ride saved to history, link to find next ride
- Driver ride history page showing all completed rides

### 🌍 Internationalization (i18n)
- Full UI available in **4 languages**: Russian 🇷🇺, English 🇬🇧, Polish 🇵🇱, Belarusian 🇧🇾
- Language switcher in every page's navbar
- Implemented via Spring MVC `LocaleResolver` + `messages_*.properties` files

---

## 🛠 Tech Stack

### Backend
| Technology | Version | Purpose |
|---|---|---|
| Java | 17 | Core language |
| Spring Boot | 3.2.2 | Application framework |
| Spring MVC | — | REST controllers, Thymeleaf views |
| Spring Security | — | Authentication, BCrypt password hashing, role-based access |
| Spring Data JPA | — | Repository layer, entity management |
| Hibernate | 6.4 | ORM |
| PostgreSQL | — | Relational database |
| Lombok | — | Boilerplate reduction (`@Getter`, `@Setter`) |
| Maven | — | Build and dependency management |

### Frontend
| Technology | Purpose |
|---|---|
| Thymeleaf | Server-side HTML templating |
| CSS3 (custom design system) | Dark Uber-style UI — variables, cards, animations, responsive layout |
| JavaScript (vanilla) | GPS detection, live polling, map interactions, address autocomplete |
| Leaflet.js | Interactive maps with OpenStreetMap tiles |
| OpenStreetMap / Nominatim | Free map tiles and address geocoding/reverse geocoding (no API key needed) |
| Google Maps (link-based) | Turn-by-turn navigation for drivers via `maps/dir/?api=1&destination=...` |

---

## 🏗 Architecture

```
src/
├── main/
│   ├── java/alina/hurchyna/ah/driver/
│   │   ├── controller/         # MVC controllers (Client, Driver, Auth)
│   │   ├── model/              # JPA entities: Client, Driver, RideRequest, RideStatus
│   │   ├── repository/         # Spring Data JPA repositories
│   │   ├── service/            # Business logic: RideService, DriverService, ClientService
│   │   └── security/           # SecurityConfig, LoginSuccessHandler, LocaleConfig
│   └── resources/
│       ├── templates/          # Thymeleaf HTML templates (13 pages)
│       ├── static/
│       │   ├── css/style.css   # Full dark design system
│       │   └── js/app.js       # GPS, map, autocomplete logic
│       ├── messages*.properties # i18n strings for RU/EN/PL/BY
│       └── application.properties
```

### Key entities
- **Client** — registered user who books rides
- **Driver** — registered driver who accepts rides
- **RideRequest** — ride order with `startLocation`, `destination`, `status` (PENDING → ACCEPTED → IN_PROGRESS → COMPLETED), `clientUsername`, `driverUsername`

### Ride lifecycle
```
Client books ride → PENDING
Driver accepts   → ACCEPTED  (client sees notification banner)
Client boards    → IN_PROGRESS (driver navigates to destination)
Ride ends        → COMPLETED (saved to driver history)
```

---

## 🚀 Running Locally

### Prerequisites
- Java 17+
- Maven 3.8+

### Start

```bash
git clone https://github.com/AlinaHurchyna/Driver.git
cd Driver
mvn spring-boot:run
```

Open: [http://localhost:8080](http://localhost:8080)

---

## 📱 Pages

| Page | URL | Role |
|---|---|---|
| Home | `/home` | Public |
| Client register | `/client/register` | Public |
| Client dashboard | `/client/dashboard` | Client |
| Client ride history | `/client/ride-history` | Client |
| Driver register | `/driver/register` | Public |
| Driver dashboard | `/api/drivers/dashboard` | Driver |
| Available rides | `/api/drivers/available-rides` | Driver |
| Navigation page | `/api/drivers/navigate/{id}` | Driver |
| Driver ride history | `/driver/ride-history` | Driver |

---

## 📸 Screenshots

### Client Dashboard — GPS + Map
![Client Dashboard](docs/screenshots/client-dashboard.png)
Dark dashboard with auto-detected location, address autocomplete, and interactive Leaflet map.

### Driver Available Rides
![Available Rides](docs/screenshots/available-rides.png)
Ride cards with pickup/destination, Google Maps navigation button, and accept button.

### Driver Navigation Page
![Driver Navigation](docs/screenshots/driver-navigation.png)
3-phase navigation flow: going to client → client boarded → destination reached.

### Ride History
![Ride History](docs/screenshots/ride-history.png)
Client ride history showing completed and active rides with dates and addresses.

---

## 🧪 Tests

Unit tests cover the core business logic in `RideService`:

```bash
mvn test
```

| Test | What it verifies |
|---|---|
| `requestRide_shouldSetStatusToPendingAndSave` | New ride gets PENDING status and is saved |
| `acceptRide_shouldSetStatusToAcceptedAndSaveDriverUsername` | Accepting a ride sets ACCEPTED + saves driver username |
| `completeRide_shouldSetStatusToCompleted` | Completing a ride sets COMPLETED status |
| `getAvailableRides_shouldReturnOnlyPendingRides` | Only PENDING rides are returned to drivers |
| `acceptRide_withNonExistentId_shouldReturnNull` | Non-existent ride returns null without saving |

---

## 🚀 Deploy on Railway

1. Fork this repo or push to your GitHub
2. Go to [railway.app](https://railway.app) → **New Project** → **Deploy from GitHub repo**
3. Add a **PostgreSQL** service in Railway dashboard
4. Set environment variables in Railway:

| Variable | Value |
|---|---|
| `DATABASE_URL` | `jdbc:postgresql://...` (Railway provides this) |
| `DB_USERNAME` | from Railway PostgreSQL credentials |
| `DB_PASSWORD` | from Railway PostgreSQL credentials |
| `DB_DRIVER` | `org.postgresql.Driver` |
| `DB_DIALECT` | `org.hibernate.dialect.PostgreSQLDialect` |

Railway auto-detects the `Dockerfile` and deploys automatically on every push to `main`.

---

## 👩‍💻 Author

**Alina Hurchyna**
[github.com/AlinaHurchyna](https://github.com/AlinaHurchyna)
