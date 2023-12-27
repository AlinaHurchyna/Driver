function require(express1) {
    return undefined;
}

const express = require('express');
const axios = require('axios');

const app = express();
const port = 3000;

app.get('/maps/map-data', async (req, res) => {
    try {
        // Wykonaj żądanie do usługi Google Maps z użyciem klucza API
        const response = await axios.get('https://maps.googleapis.com/maps/api/...', {
            params: {
                key: 'IzaSyB__jYP3hi8A6Q834mYc6KjbLSDM1fu09s', // Zastąp własnym kluczem API
                // Inne parametry żądania do Google Maps
            }
        });


        res.json(response.data);
    } catch (error) {
        console.error(error);
        res.status(500).json({error: 'Internal Server Error'});
    }
});

app.listen(port, () => {
    console.log(`Server listening at http://localhost:${port}`);
});
