<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
    <#include "../nav/nav.ftlh">
    <div class="p-5 text-center bg-light">
        <h1 class="mb-3">List of Cars</h1>
    </div>
    <a href="/ui/cars/new">
        <button type="button" class="btn btn-success">Add new car</button>
    </a>
    <table id="locations-table" class="table">
        <thead>
        <tr>
            <th>Manufacturer</th>
            <th>Model</th>
            <th>Reg. Number</th>
            <th>Seat Capacity</th>
            <th>Transmission</th>
            <th>Rent per day</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <#if cars ? has_content>
            <#list cars as car>
                <tr>
                    <td>${(car.manufacturer)!}</td>
                    <td>${(car.model)!}</td>
                    <td>${(car.regNumber)!}</td>
                    <td>${(car.seatCapacity)!}</td>
                    <td>${(car.typeTransmission)!}</td>
                    <td>${(car.rentPerDay)!}</td>
                    <td>${(car.typeTransmission)!}</td>
                    <td>
                        <form method="POST" action="/ui/cars/delete/${car.id}">
                            <button type="submit" class="btn-danger" action="/locations">Delete</button>
                        </form>
                        <a href="/ui/cars/${car.id}"><button class="btn">Edit</button></a>
                    </td>
                </tr>
            </#list>
        <#else>
            <tr>No locations available</tr>
        </#if>
        </tbody>
    </table>


</body>
</html>