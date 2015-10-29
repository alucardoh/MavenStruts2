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
        <script>
            window.onload = function () {
                document.getElementById("submitbutton").hidden = true;
                var input = document.getElementById('fileselect');
                var nombre = "";
                var size = 0;
                input.addEventListener('change', function () {
                    var archive = document.getElementById("fileselect").files[0];
                    var reader = new FileReader();
                    reader.onload = (function (e) {
                        var archi = e.target.result + "";
                        //document.getElementById("archivo").value = "123";
                        document.getElementById("archivo").value = archi;
                        document.getElementById("submitbutton").hidden = false;
                    });
                    document.getElementById("size").value = archive.size;
                    document.getElementById("nombre").value = archive.name;
                    document.getElementById("ext").value = archive.name.split('.').pop();
                    reader.readAsDataURL(archive);

                });
            }
        </script>
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
        <form id="upload" action="uploadaction" method="POST" enctype="multipart/form-data">

            <fieldset>
                <legend>Subir nuevo archivo</legend>

                <input type="hidden" id="MAX_FILE_SIZE" name="MAX_FILE_SIZE" value="300000" />

                <div>
                    <label for="fileselect">Selecciona el archivo:</label>
                    <input type="file" id="fileselect" name="fileselect"/>
                    <input type="hidden" name="archivo" id="archivo"/>
                    <input type="hidden" name="nombre" id="nombre"/>
                    <input type="hidden" name="size" id="size"/>
                    <input type="hidden" name="delete" id="delete" value = "" />
                    <input type="hidden" name="ext" id="ext"/>
                    <input type="hidden" name="name" value="<s:property value="name"/>"/>
                    <input type="hidden" name="user" value="<s:property value="user"/>"/>
                    <div id="filedrag">Arrastra un archivo para subirlo</div>
                </div>

                <div id="submitbutton">
                    <button type="submit">Upload Files</button>
                </div>

            </fieldset>

        </form>

        <div id="messages">

            <h3>Archivos:</h3>  
            <s:iterator  value="list">  
                <fieldset>  
                    <s:property value="nombre"/> <br>
                    <s:property value="ext"/> <br>
                    <s:property value="size"/> <br>
                    <a href='<s:property value="archivo"/>' target="_blank">link</a>

                    <form id="deleteaction" action="deleteaction" method="POST" enctype="multipart/form-data">
                        <input type="hidden" name="delete" id="delete" value = "<s:property value="nombre"/>" />
                        <input type="hidden" name="name" value="<s:property value="name"/>"/>
                        <input type="hidden" name="user" value="<s:property value="user"/>"/>
                        <div id="submitbutton">
                            <button type="submit">Borrar</button>
                        </div>
                    </form>
                </fieldset>  
            </s:iterator>  

        </div>
    </body>
</html>


