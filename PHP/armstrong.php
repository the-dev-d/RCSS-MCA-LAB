<?php

if(isset($_GET['number'])) {
    $number = $_GET['number'];
    $sum = 0;
    $temp = $number;
    while($temp != 0) {
        $remainder = $temp % 10;
        $sum = $sum + $remainder * $remainder * $remainder;
        $temp = $temp / 10;
    }
    if($number == $sum) {
        $response = "<p>$number is an Armstrong number.</p>";
    } else {
        $response = "<p>$number is not an Armstrong number.</p>";
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Armstrong</title>
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
            background-color:  rgb(36, 202, 138);
            padding: 0.5rem;
            color: white;
            border-radius: 0.5rem;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <form class="container" action="armstrong.php" method="get">
        <div>
            <label for="number">Enter a number</label>
            <input type="number" name="number" id="number">
        </div>
        <input type="submit" value="Submit">
        <?php
            if(isset($response)) {
                echo $response;
            }
        ?>
    </form>
</body>
</html>