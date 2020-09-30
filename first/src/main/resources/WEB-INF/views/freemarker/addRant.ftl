<#import "/spring.ftl" as spring /> <!-- Имортирование макроопределений -->
<html>                              <!-- Spring для FreeMarker -->
    <head>
        <title><@spring.message "title.addRant"/></title>
        <style>
            .error{
                color: #ff0000;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <h2><@spring.message "title.addRant"/></h2>
        <form method="POST" action="addRant.htm">
            <!-- Связывание полей формы со свойствами объекта -->
            <b><@spring.message "field.state"/> </b> <@spring.formInput
                        "rant.vehicle.state", ""/><br/>
            <b><@spring.message "field.plateNumber" /><br/>
            <@spring.formInput "rant.vehicle.plateNumber", ""/><br/>
            <@spring.message "field.rantText"/>
            <@spring.formTextarea "rant.rantText", "rows"='5' cols='50'" />

            <inpute type="submit" />
        </form>
    </body>
</html>