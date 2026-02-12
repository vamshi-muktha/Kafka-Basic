<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Kafka Car Tracking</title>

    <!-- Leaflet CSS -->
    <link rel="stylesheet"
          href="https://unpkg.com/leaflet@1.9.4/dist/leaflet.css"/>

    <!-- Leaflet JS -->
    <script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"></script>

    <style>
        #map {
            height: 500px;
            width: 100%;
        }
    </style>
</head>

<body>

<h2>🚗 Live Kafka Car Tracking</h2>
<div id="map"></div>

<script>
    // Initial map
    let map = L.map('map').setView([17.3850, 78.4867], 13);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '© OpenStreetMap'
    }).addTo(map);

    // Car marker
    let carMarker = L.marker([17.3850, 78.4867]).addTo(map)
        .bindPopup("Car");

    function updateLocation() {
        fetch('/api/location')
            .then(res => res.json())
            .then(data => {
                if (!data) return;

                let lat = data.latitude;
                let lon = data.longitude;

                carMarker.setLatLng([lat, lon]);
                map.panTo([lat, lon]);

                carMarker.bindPopup(
                    "🚗 " + data.vehicleId +
                    "<br/>Speed: " + data.speed
                );
            });
    }

    // Poll every 2 seconds
    setInterval(updateLocation, 2000);
</script>

</body>
</html>
