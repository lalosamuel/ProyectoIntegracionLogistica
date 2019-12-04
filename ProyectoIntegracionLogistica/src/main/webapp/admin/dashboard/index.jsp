<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<mt:admin_plantilla title="Dashboard">
	<jsp:attribute name="content">
	
	
	<!-- Main content -->
    <section class="content">
      
       <div class="row">
        <div class="col-xs-12">
          
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Listado de Productos</h3>
              <input type="hidden" id="respuesta" value="1">
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              
              <table class="table table-striped table-bordered nowrap dataTable dtr-inline" cellspacing="0" width="100%" role="grid" aria-describedby="example_info" style="width: 100%;" id="tablaProducto">
              
                <thead>
                <tr>
                  <th>N°</th>
                  <th>Producto</th>
                  <th>Descripción</th>
                  <th>Categoria</th>
                  <th>Estado</th>
                  <th></th>
                  
                </tr>
                </thead>
                <tbody>
              
                <c:forEach var="producto" items="${listProducto}" varStatus="status">
                <tr>
                  <td>${status.index + 1}</td>
                  <td>${producto.nombre}</td>
                  <td>${producto.descripcion}</td>
                  <td>${producto.categoria}</td>
                  <td>${producto.estado}</td>
                  <td><a href="editarProducto?id=${producto.id}" class="btn btn-primary"><span class="fa fa-edit"></span></a>
					 <a href="borrarProducto?id=${producto.id}" class="btn btn-primary"><span class="glyphicon glyphicon-trash"></span></a>
				  </td>
                  
                </tr>
                </c:forEach>
                
                </tbody>
                
              </table>
            </div>
            <!-- /.box-body -->
            
            
             <div class="box-footer">
             
             <a class="btn btn-primary" id="btnNuevo" href="nuevo" role="button">Nuevo</a>
              
            </div>
            
            
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
      
    	

    	
    	
      
    </section>
    <!-- /.content -->
    
    
   
   
   <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
   
   
 
 
   
	
	 <script>
  $(function () {
    $('#example1').DataTable()
    $('#example2').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
    })
  })
</script>
	
	
		 


<script>
    $(document).ready(function() {
        $('#tablaProducto').DataTable({
            responsive: true,
            
            language: espanol
        });
    });

    var espanol = {
        "sProcessing": "Procesando...",
        "sLengthMenu": "Mostrar _MENU_ registros",
        "sZeroRecords": "No se encontraron resultados",
        "sEmptyTable": "Ningún dato disponible en esta tabla",
        "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
        "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
        "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
        "sInfoPostFix": "",
        "sSearch": "Buscar:",
        "sUrl": "",
        "sInfoThousands": ",",
        "sLoadingRecords": "Cargando...",
        "oPaginate": {
            "sFirst": "Primero",
            "sLast": "Último",
            "sNext": "Siguiente",
            "sPrevious": "Anterior"
        },
        "oAria": {
            "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
            "sSortDescending": ": Activar para ordenar la columna de manera descendente"
        }
    }


    </script>
    
	
	
	
	</jsp:attribute>
	
	
	

	
</mt:admin_plantilla>


