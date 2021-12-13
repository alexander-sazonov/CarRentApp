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
    <div class="container-fluid">
        <div class="p-5 text-center bg-light">
            <h1 class="mb-3">Locations table</h1>
            <a href="/ui/locations/new">
                <button type="button" class="btn btn-success">Create location</button>
            </a>

            <table id="locations-table" class="table">
                <thead>
                <tr>
                    <th>Country</th>
                    <th>City</th>
                    <th>Address</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <#if locations ? has_content>
                    <#list locations as location>
                        <tr>
                            <td>
                                ${location.country}
                            </td>
                            <td>${location.city}</td>
                            <td>${location.address}</td>
                            <td>${location.email}</td>
                            <td>${location.phone}</td>
                            <td>
                                <form method="POST" action="/ui/locations/delete/${location.id}">
                                    <button type="submit" class="btn-danger" action="/locations">Delete</button>
                                </form>
                                <a href="/ui/locations/${location.id}"><button class="btn">Edit</button></a>
                            </td>
                        </tr>
                    </#list>
                <#else>
                    <tr>No locations available</tr>
                </#if>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>