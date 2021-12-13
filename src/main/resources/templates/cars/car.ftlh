<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Car Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<#include "../nav/nav.ftlh">
<div class="container-fluid">
    <form method="post" action="/ui/cars" modelAttribute= "carDto">
        <input type="hidden" id="id" name="id" value="${(car.id)!}">
        <div class="form-group">
            <label for="registrationNumber">Registration number</label>
            <input type="text" class="form-control" id="registrationNumber" name="registrationNumber"
                   placeholder="Enter registration number of a car" value="${(car.regNumber)!}">
        </div>
        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <input type="text" class="form-control" id="manufacturer" name="manufacturer"
                   placeholder="Enter the brand of the car" value="${(car.manufacturer)!}">
        </div>
        <div class="form-group">
            <label for="model">Model</label>
            <input type="text" class="form-control" id="model" name="model"
                   placeholder="Enter the model of the car" value="${(car.manufacturer)!}">
        </div>
        <div class="form-group">
            <label for="seatCapacity">Seat capacity</label>
            <input type="number" class="form-control" id="seatCapacity" name="seatCapacity"
                   placeholder="Enter the number of seats" value="${(car.seatCapacity)!}">
        </div>
        <div class="form-group">
            <label for="transmissionType">Transmission type</label>
            <select name="transmissionType" id="transmissionType">
                <#list transmissionTypes as type>
                    <option value="${type}" ${(type == car.typeTransmission.name())?then('selected','')}>${type}</option>
                </#list>
            </select>
        </div>
        <div class="form-group">
            <#if locations ? has_content>
                <label>Location</label>
                <select name="location" id="location">
                    <#list locations as location>
                        <option value="${location}" ${(location.id == (car.location.id)!)?then('selected','')}>${location.country} ${location.city} ${location.address}</option>
                    </#list>
                </select>
            <#else>
                <p>No location available</p>
            </#if>
            <a href="/ui/locations/new"><button>Add new location</button></a>
        </div>
        <div class="form-group">
            <label for="rentPerDay">Rent per day</label>
            <input name="rentPerDay" id="rentPerDay" value="${(car.rentPerDay)!}">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>