$(document).ready(
        function() {
            $.ajax({
                type: 'GET',
                //cambiar path a 25.66.75.32:8080
                url: 'http://localhost:8080/proyectoDB2-seguro/GetAllCitas?hospNum=1',
                dataType: 'json',
                success: function(data) {
                    var $pData = $('#historialData');
                    $pData.empty();
                    for (var i = 0; i < data.length; i++) {
                        //$pData.append("<tr><td>"+data[i].id+"</td><td>"+data[i].cat+"</td><td>"+data[i].docName+" "+data[i].docLastName+"</td><td>"+data[i].pName+" "+data[i].pLastName+"</td><td>"+data[i].fecha+"</td><td><a class=\"button\" href=\"cita_h.jsp?citaId="+data[i].id+"&pId="+data[i].pId+"\">Ver detalles</a> <a class=\"button\" href=\"deleteC_h.jsp?citaId="+data[i].id+"\">Eliminar Cita</a></td></tr>");
                        $pData.append("<tr><td>"+data[i].id+"</td><td>"+data[i].cat+"</td><td>"+data[i].docName+" "+data[i].docLastName+"</td><td>"+data[i].pName+" "+data[i].pLastName+"</td><td>"+data[i].fecha+"</td><td><a class=\"button\" href=\"cita_h.jsp?citaId="+data[i].id+"&pId="+data[i].pId+"\">Ver detalles</a></td></tr>");
                    }
                    if(data.length==0){
                        $pData.append("<p>No hay datos disponibles</p>");
                    }

                },
                error : function() {
                    var $pData = $('#historialData');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});






