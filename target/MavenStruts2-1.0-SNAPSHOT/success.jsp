<%-- 
    Document   : success
    Created on : 28/10/2015, 08:17:05 PM
    Author     : rodrigo
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>Successful Login</title>
        <style>
            #filedrag
            {
                display: none;
                font-weight: bold;
                text-align: center;
                padding: 1em 0;
                margin: 1em 0;
                color: #555;
                border: 2px dashed #555;
                border-radius: 7px;
                cursor: default;
            }

            #filedrag.hover
            {
                color: #f00;
                border-color: #f00;
                border-style: solid;
                box-shadow: inset 0 3px 4px #888;
            }
        </style>
    </head>
    <body>
        Bienvenido, <s:property value="name"/>
        <form id="upload" action="upload.php" method="POST" enctype="multipart/form-data">

            <fieldset>
                <legend>Subir nuevo archivo</legend>

                <input type="hidden" id="MAX_FILE_SIZE" name="MAX_FILE_SIZE" value="300000" />

                <div>
                    <label for="fileselect">Selecciona el archivo:</label>
                    <input type="file" id="fileselect" name="fileselect"/>
                    <input type="hidden" name="archivo" id="archivo"/>
                    <input type="hidden" name="nombre" id="nombre"/>
                    <input type="hidden" name="size" id="size"/>
                    <input type="hidden" name="ext" id="ext"/>
                    <div id="filedrag">Arrastra un archivo para subirlo</div>
                </div>

                <div id="submitbutton">
                    <button type="submit">Upload Files</button>
                </div>

            </fieldset>

        </form>

        <div id="messages">
            <p>Status Messages</p>
        </div>
    </body>
</html>

