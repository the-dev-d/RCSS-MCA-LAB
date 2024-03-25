<?php

if(isset($_GET['decimal'])) {
    $decimal = $_GET['decimal'];
    $binary = decbin($decimal);
    $response = "<p>Binary: $binary</p>";
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Decimal PHP</title>
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
        form div {
            display: grid;
            grid-template-columns: min-content 1fr;
            gap: 1rem;
            place-items: center;
        }
        label {
            text-wrap: nowrap;
        }
        .container {
            background-color: #fff;
            padding: 1rem;
            border-radius: 0.5rem;
            width: 50%;
        }
        input[type="number"] {
            padding: 0.5rem;
            margin-top: 5px;
            width: 100%;
        }
        input[type="submit"] {
            margin-top: 10px;
            border-radius: 0.5rem;
            outline: none;
            border: none;
            background-color:  rgb(36, 202, 138);
            padding: 1rem;
        }
    </style>
</head>
<body>
    <div class="container">
        <form method="get" action="">
            <div>
                <label for="decimal">Enter a decimal number:</label>
                <input type="number" name="decimal" id="decimal" required>
            </div>
            <input type="submit" value="Convert">
            <?php
                if(isset($response)) {
                    echo $response;
                }
            ?>
        </form>
    </div>
</body>
</html>