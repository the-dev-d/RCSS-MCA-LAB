<?php

    $username = "root";
    $password = "";
    $server = 'localhost';
    $db = 'TODO';
    $con = new mysqli($server, $username, $password, $db);
    // $query = "CREATE TABLE `TODO`.`todo` (`id` INT NOT NULL AUTO_INCREMENT , `task` VARCHAR(100) NOT NULL , `data` DATE NOT NULL DEFAULT CURRENT_TIMESTAMP , `status` BIT(1) NOT NULL DEFAULT b'' , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
    // $con->query($query);

    echo $_GET['action'];   
    if($_GET['action'] == 'add') {
        $task = $_GET['task'];
        $insert = "INSERT INTO todo (task) VALUES ('$task')";
        $con->query($insert);
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CRUD</title>
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
            margin-top: 0.5rem;
            background-color: rgb(181, 247, 211);
            border: none;
            border-radius: 0.5rem;
        }

    </style>
</head>
<body>
    <div class="container">
        <form action="crud.php?action=add">
            <div>
                <label for="task">Task</label>
                <input type="text" name="task" id="task">
            </div>
            <button type="submit">Add Task</button>
        </form>
        <div>
            <?php 
                $select = "SELECT * FROM todo";
                $result = $con->query($select);
                while($row = $result->fetch_assoc()) {
                    echo "<div>";
                    echo "<p>{$row['task']}</p>";
                    echo "<a href='crud.php?action=edit&id={$row['id']}'>Edit</a>";
                    echo "<a href='crud.php?action=delete&id={$row['id']}'>Delete</a>";
                    echo "</div>";
                }
            ?>
        </div>
    </div>
</body>
</html>