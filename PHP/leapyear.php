<?php

if(isset($_GET['year'])) {
    $year = $_GET['year'];
    if($year % 4 == 0) {
        if($year % 100 == 0) {
            if($year % 400 == 0) {
                $response = "<p>$year is a leap year.</p>";
            } else {
                $response = "<p>$year is not a leap year.</p>";
            }
        } else {
            $response = "<p>$year is a leap year.</p>";
        }
    } else {
        $response = "<p>$year is not a leap year.</p>";
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Leap Year</title>
    <style>
        body {
            font-family: Poppins, sans-serif;
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
    <form class="container" action="leapyear.php" method="get">
        <div>
            <label for="number">Enter a year</label>
            <input type="number" name="year" id="year">
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