<?php

    $username = "root";
    $password = "";
    $server = 'localhost';
    $db = 'TODO';
    $con = new mysqli($server, $username, $password, $db);
    // $query = "CREATE TABLE `TODO`.`todo` (`id` INT NOT NULL AUTO_INCREMENT , `task` VARCHAR(100) NOT NULL , `data` DATE NOT NULL DEFAULT CURRENT_TIMESTAMP , `status` BIT(1) NOT NULL DEFAULT b'' , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
    // $con->query($query);
  
    if($_GET['action'] == 'add') {
        $task = $_POST['task'];
        $insert = "INSERT INTO todo (task) VALUES ('$task')";
        $con->query($insert);
        header('Location: crud.php');
    }
    if($_GET['action'] == 'delete') {
        $id = $_GET['id'];
        $delete = "DELETE FROM todo WHERE id = $id";
        $con->query($delete);
        header('Location: crud.php');
    }
    if($_GET['action'] == 'update') {
        $id = $_GET['id'];
        $task = $_POST['task'];
        $update = "UPDATE todo SET task = '$task' WHERE id = $id";
        $con->query($update);
        header('Location: crud.php');
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
            grid-template-columns: min-content 1fr;
            gap: 2rem;
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
        form {
            width: 20rem;
        }
        button {
            padding: 0.5rem 1rem;
            width: 100%;
            margin-top: 0.5rem;
            background-color: rgb(181, 247, 211);
            border: none;
            border-radius: 0.5rem;
        }
        .tasks {
            width: 100%;
            height: fit-content;
        }
        .task {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 0.5rem;
            height: fit-content;
            margin: 0;
        }
        .links {
            display: flex;
            gap: 1rem;
            margin: 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <?php
            if(isset($_GET['action']) && $_GET['action'] == 'edit') {
                $id = $_GET['id'];
                $select = "SELECT * FROM todo WHERE id = $id";
                $result = $con->query($select);
                $row = $result->fetch_assoc();
                echo "<form action='crud.php?action=update&id={$row['id']}' method='post'>";
                echo "<label for='task'>Task</label>";
                echo "<input type='text' name='task' id='task' value='{$row['task']}'>";
                echo "<button type='submit'>Update</button>";
                echo "</form>";
            } else {
                echo "<form action='crud.php?action=add' method='post'>";
                echo "<label for='task'>Task</label>";
                echo "<input type='text' name='task' id='task'>";
                echo "<button type='submit'>Add</button>";
                echo "</form>";
            }
        ?>
        <div class="tasks">
            <?php 
                $select = "SELECT * FROM todo";
                $result = $con->query($select);
                while($row = $result->fetch_assoc()) {
                    echo "<div class='task'>";
                    echo "<p>{$row['task']}</p> <div class='links'>";
                    echo "<a href='crud.php?action=edit&id={$row['id']}'>Edit</a>";
                    echo "<a href='crud.php?action=delete&id={$row['id']}'>Delete</a>";
                    echo "</div></div>";
                }
            ?>
        </div>
    </div>
</body>
</html>