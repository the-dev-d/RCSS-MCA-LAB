<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cookies</title>
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
        div {
            background-color: #fff;
            padding: 1rem;
            border-radius: 0.5rem;
            width: 50%;
            display: grid;
            place-items: center;
        }
    </style>
</head>
<body>
    <div>
        <h1>
            <?php
            if(isset($_COOKIE['visited'])) {
                echo "Welcome back!";
            }else {
                setcookie('visited', date("F jS - g:i a"), time() + (86400 * 30));
                echo "Welcome!";
            }
            ?>
        </h1>
        <p>
            <?php
            if(isset($_COOKIE['visited'])) {
                echo "You last visited on " . $_COOKIE['visited'];
            }
            setcookie('visited', date("F jS - g:i a"), time() + (86400 * 30));
            ?>
        </p>
    </div>
</body>
</html>