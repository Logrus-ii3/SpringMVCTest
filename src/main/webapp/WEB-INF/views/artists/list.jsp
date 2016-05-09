<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/views/common/page-head.jsp" />
</head>
<body>
    <c:import url="/WEB-INF/views/common/page-body-header.jsp" />
    Artists
    <div id="divArtistsList" class="hide">
        <table id="artistsList" class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>#</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>
    <table class="hide">
        <tbody id="artistsList-template">
            <tr>
                <td>{rowNum}</td>
                <td>{artistId}</td>
                <td>{artistName}</td>
                <td><a href="#"
                    onclick="deleteArtist({artistId}); return false;">Delete</a></td>
            </tr>
        </tbody>
    </table>
    <form id="formNewArtist">
        <table class="table">
            <tr>
                <td>Имя исполнителя:</td>
                <td><input type="text" id="inputArtistName" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="button"
                    value="Создать" onclick="addArtist();" /></td>
            </tr>
        </table>
    </form>
    <c:import url="/WEB-INF/views/common/page-body-footer.jsp" />
    <script type="text/javascript">
        function addArtist() {

        }

        function renderData(resultJson) {
            var rowTemplate = $('#artistsList-template').html();
            var rows = '';
            var i = 1;
            for ( var artistIdx in resultJson) {
                var artist = resultJson[artistIdx];

                rows += rowTemplate.replace(/{rowNum}/g, i).replace(
                        /{artistName}/g, artist.name).replace(
                        /{artistId}/g, artist.id);
                i++;
            }
            $('#artistsList tbody').empty().append(rows);
            $('#divArtistsList').removeClass('hide');
        }

        function deleteArtist(id) {
            var url = '<c:url value="/rest/artists"/>/'+id+'/delete';

            $.post(url, function(response) {
                loadData();
            }, 'text').fail(function(response) {
                var exc = !!response.responseJSON ? response.responseJSON : {
                    exc : 'Server call failed: ' + response.statusText
                };
                alert("Error: " + exc.exc);
            });
        }

        function loadData() {
            var url = '<c:url value="/rest/artists"/>';

            $.get(url, function(response) {
                renderData(response);
            }, 'json').fail(function(response) {
                var exc = !!response.responseJSON ? response.responseJSON : {
                    exc : 'Server call failed: ' + response.statusText
                };
                alert("Error: " + exc.exc);
            });
        }

        onDocumentReady.subscribe(loadData);
    </script>
</body>
</html>