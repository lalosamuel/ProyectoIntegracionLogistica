<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>





   <!-- Main content -->
    <section class="content">
    
    
     <div class="row">
        <!-- left column -->
        <div class="col-md-12">
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Datos del Producto</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form:form action="guardaProducto" method="post" modelAttribute="producto">
              <div class="box-body">
              
              
               <div class="form-group">
               <form:hidden path="id"/>
                  <label for="lNombre">Nombre</label>
                  <form:input path="nombre" type="text" placeholder="Ingrese nombre" minlength="1" maxlength="100"  class="form-control" />
                  
                </div>
                
               <div class="form-group">
                  <label for="lDescripcion">Descripcion</label>
                  <form:input path="descripcion" type="text" placeholder="Ingrese descripcion" minlength="1" maxlength="200" class="form-control" />
                  
                  
                </div>
                
                <div class="form-group">
                  <label for="lCategoria">Categoria</label>
                  <form:input path="categoria" type="text" placeholder="Ingrese categoria" minlength="1" maxlength="100" class="form-control" />
                  
                  
                </div>
                
                <div class="form-group">
                  <label for="lEstado">Estado</label>
                  <form:input path="estado" type="text" value="1" placeholder="Ingrese estado" minlength="1" maxlength="1" readonly="true" pattern="[0-9]{1}"  class="form-control"  />
                  
                </div>
              
                
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                
                <input type="submit" value="Guardar" name="btnGrabar" class="btn btn-primary">
              </div>
            </form:form>
          </div>
    
    </div>
    </div>
    

	

    </section>
    <!-- /.content -->