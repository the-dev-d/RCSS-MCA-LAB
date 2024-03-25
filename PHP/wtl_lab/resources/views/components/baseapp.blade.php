<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WTL Lab</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(45deg, rgb(169, 250, 210), rgb(125, 219, 248));
            margin: 0;
            padding: 0;
            display: grid;
            place-items: center;
            height: 100vh;
        }
        div {   
            width: 50%;
            text-align: center;
            padding: 2rem;
            border-radius: 0.5rem;
            background: rgb(255, 255, 255);
        }
    </style>
</head>
<body>
    {{$slot}}
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>