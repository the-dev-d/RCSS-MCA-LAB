<?php

if($_SERVER['REQUEST_METHOD'] === 'POST') {
    $email = $_POST['email'];
    $name = $_POST['name'];
    $subject = $_POST['subject'];
    $message = $_POST['message'];

    $to = $_POST['to'];
    $headers = "From: $name <$email>";
    mail($to, $subject, $message, $headers);
    $response = "<p>Email sent successfully.</p>";
}

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Email</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }
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
        .container {
            background-color: #fff;
            padding: 1rem;
            border-radius: 0.5rem;
            width: 50%;
            display: grid;
            place-items: center;
        }
        div {
            margin-bottom: 1rem;
        }
        label {
            display: block;
            margin-bottom: 0.5rem;
        }
        input, textarea {
            width: 100%;
            padding: 0.5rem;
            margin-top: 0.5rem;
        }
        button {
            padding: 0.5rem 1rem;
            width: 100%;
            background-color: rgb(36, 202, 138);
            color: #fff;
            border: none;
            border-radius: 0.5rem;
            cursor: pointer;
        }
        form {
            width: 100%;
        }
        textarea {
            resize: vertical;
        }
        p {
            margin: 1rem 0rem;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Email</h1>
        <form action="email.php" method="post">
            <div>
                <label for="email">Email:</label>
                <input type="email" name="email" id="email" required>
            </div>
            <div>
                <label for="name">Name:</label>
                <input type="text" name="name" id="name" required>
            </div>
            <div>
                <label for="to">To:</label>
                <input type="email" name="to" id="to" required>
            </div>
            <div>
                <label for="subject">Subject:</label>
                <input type="text" name="subject" id="subject" required>
            </div>
            <div>
                <label for="message">Message:</label>
                <textarea name="message" id="message" required></textarea>
            </div>
            <button type="submit">Send</button>
            <?php
                if(isset($response)) {
                    echo $response;
                }
            ?>
        </form>
    </div>
</body>
</html>