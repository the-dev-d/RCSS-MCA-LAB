
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Global</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: rgb(181, 247, 211);
        }
        div {
            background-color: #fff;
            padding: 1rem;
            border-radius: 0.5rem;
            width: 50%;
            display: grid;
            place-items: center;
        }
        span {
            margin-top: 0.5rem;
        }
    </style>
</head>
<body>
    <div>
    <?php
        $globalVariable = 10;
        function accessGlobal() {
            global $globalVariable;
            echo "<span> Global variable inside function: " . $globalVariable . "</span>";
        }
        accessGlobal();
        $globalVariable = 20;
        accessGlobal();
    ?> 
    </div>
</body>
</html>