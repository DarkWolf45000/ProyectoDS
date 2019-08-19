use DBProyecto;


drop procedure if exists verificar;
delimiter //
create procedure verificar (IN usuarios char(10), contrasena char(10))
Begin
	SELECT usuario,clave FROM Cuentas WHERE usuario=usuarios AND clave=contrasena;
End //
delimiter ;


drop procedure if exists buscar_categoria;
delimiter //
create procedure buscar_categoria (IN categoria char(20))
Begin
	Select producto.idProducto,nombre,categoria,descripcion,precio,productos_bodega.cantidad 
    from producto 
    inner join productos_bodega on producto.categoria=categoria and productos_bodega.idProducto=producto.idProducto and eliminado=0;
End //
delimiter ;

drop procedure if exists buscar_nombre;
delimiter //
create procedure buscar_nombre (IN nombre char(50))
Begin
	Select producto.idProducto,nombre,categoria,descripcion,precio,productos_bodega.cantidad 
    from producto 
    inner join productos_bodega on producto.nombre=nombre and productos_bodega.idProducto=producto.idProducto and producto.eliminado=0;
End //
delimiter ;

drop procedure if exists obtenerProductosTodos;
delimiter //
create procedure obtenerProductosTodos ()
Begin
	Select producto.idProducto,nombre,categoria,descripcion,precio,productos_bodega.cantidad 
    from producto 
    inner join productos_bodega on productos_bodega.idProducto=producto.idProducto and producto.eliminado=0;
End //
delimiter ;


drop procedure if exists buscar_descripcion;
delimiter //
create procedure buscar_descripcion (IN descripcion char(100))
Begin
	Select producto.idProducto,nombre,categoria,descripcion,precio,productos_bodega.cantidad
    from producto 
    inner join productos_bodega on producto.descripcion=descripcion and productos_bodega.idProducto=producto.idProducto and eliminado=0;
End //
delimiter ;

drop procedure if exists dar_admin;
delimiter //
create procedure dar_admin (IN cedula char(10), idSuc int)
Begin
	Insert into administrador values (cedula,idSuc);
End //
delimiter ;

drop procedure if exists ped_bodega;
delimiter //
create procedure ped_bodega (IN idbodega int)
Begin
	select idPedido,idRepartidor,estado,HoraSalida,HoraEntrega from pedido where idBodega=idbodega and eliminado=0;
End //
delimiter ;

drop procedure if exists ped_especifico;
delimiter //
create procedure ped_especifico (IN idpedido int)
Begin
	select idRepartidor,estado,HoraSalida,HoraEntrega from pedido where pedido.idPedido=idpedido and eliminado=0;
End //
delimiter ;

drop procedure if exists repartidor_bodega;
delimiter //
create procedure repartidor_bodega (IN idbodega int)
Begin
	select empleados.Cedula, empleados.nombres, empleados.apellidos, empleados.edad
    from repartidor_bodega
			inner join
		empleados on repartidor_bodega.idRepartidor = empleados.Cedula
	where
		repartidor_bodega.idBodega=idbodega
	order by empleados.apellidos;
End //
delimiter ;

drop procedure if exists ped_actualizar;
delimiter //
create procedure ped_actualizar (IN idpedido int, idrepartidor char(10), estado char(15),horasal time,horaent time)
Begin
	update pedido set idRepartidor=idrepartidor,estado=estado,HoraSalida=horasal,HoraEntrada=horaent where pedido.idPedido=idpedido;
End //
delimiter ;	

drop procedure if exists obtenerAdmins;
delimiter //
create procedure obtenerAdmins (IN usuarios char(10), contrasena char(10))
Begin
	SELECT empleados.Cedula, empleados.nombres, empleados.apellidos
	FROM empleados 
	INNER JOIN Cuentas 
	ON empleados.idCuenta=Cuentas.idCuenta and Cuentas.usuario=usuarios and Cuentas.clave=contrasena 
	INNER JOIN administrador 
	ON administrador.idAdministrador=empleados.Cedula;
End //
delimiter ;

drop procedure if exists obtenerGerente;
delimiter //
create procedure obtenerGerente (IN usuarios char(10), contrasena char(10))
Begin
	SELECT empleados.Cedula, empleados.nombres, empleados.apellidos
	FROM empleados
	INNER JOIN Cuentas ON empleados.idCuenta=Cuentas.idCuenta and Cuentas.usuario=usuarios and Cuentas.clave=contrasena
    INNER JOIN gerente ON gerente.idGerente=empleados.Cedula;
End //
delimiter; 

drop procedure if exists obtenerVendedor;
delimiter //
create procedure obtenerVendedor (IN usuarios char(10), contrasena char(10))
Begin
	SELECT empleados.Cedula, empleados.nombres, empleados.apellidos
	FROM empleados
	INNER JOIN Cuentas ON empleados.idCuenta=Cuentas.idCuenta and Cuentas.usuario=usuarios and Cuentas.clave=contrasena
    INNER JOIN vendedor ON vendedor.idVendedor=empleados.Cedula;
End //
delimiter ;

drop procedure if exists obtenerJefeBodega;
delimiter //
create procedure obtenerJefeBodega (IN usuarios char(10), contrasena char(10))
Begin
	SELECT empleados.Cedula, empleados.nombres, empleados.apellidos
	FROM empleados
	INNER JOIN Cuentas ON empleados.idCuenta=Cuentas.idCuenta and Cuentas.usuario=usuarios and Cuentas.clave=contrasena
    INNER JOIN jefebodega ON jefebodega.idJefe=empleados.Cedula;
    
End //
delimiter ;

drop procedure if exists obtenerBodega;
delimiter //
create procedure obtenerBodega (IN idJefe char(10))
Begin
	SELECT Bodega.idBodega, Bodega.direccion
	FROM Bodega
	INNER JOIN jefebodega ON jefebodega.idJefe=idJefe and jefebodega.idBodega=Bodega.idBodega;
End //
delimiter ;

drop procedure if exists obtenerProductosBodega;
delimiter //
create procedure obtenerProductosBodega (IN idBodega int)
Begin
	SELECT productos_bodega.Cantidad, Producto.idProducto, Producto.descripcion, Producto.categoria, Producto.Precio
	FROM Bodega
	INNER JOIN productos_bodega ON Bodega.idBodega=productos_bodega.idBodega and Bodega.idBodega=idBodega
    INNER JOIN Producto ON Producto.idProducto=productos_bodega.idProducto;
End //
delimiter ;

drop procedure if exists obtenerPedidosSucursalBodega;
delimiter //
create procedure obtenerPedidosSucursalBodega (IN idBodega int)
Begin
	SELECT Pedido.idPedido, Pedido.estado, pedido_sucursal.idSucursal
	FROM Bodega
	INNER JOIN Pedido ON Pedido.idBodega=Bodega.idBodega and Bodega.idBodega=idBodega
    INNER JOIN pedido_Sucursal ON pedido_sucursal.idPedido=Pedido.idPedido;
End //
delimiter ;

drop procedure if exists verificarMatriz;
delimiter //
create procedure verificarMatriz(IN idSucursal int)
Begin
	SELECT Sucursal.direccion, Sucursal.matriz
	FROM Sucursal
	WHERE sucursal.idSucursal=idSucursal;
End //
delimiter ;

drop procedure if exists obtenerProductosPedido;
delimiter //
create procedure obtenerProductosPedido(IN idPedido int)
Begin
	SELECT Producto.idProducto, Producto.descripcion, Producto.categoria , Producto.precio, productos_pedido.cantidad 
	FROM Pedido
	INNER JOIN productos_pedido ON productos_pedido.idPedido=Pedido.idPedido and idPedido=Pedido.idPedido
    INNER JOIN Producto ON productos_pedido.idProducto=Producto.idProducto;
End //
delimiter ;

drop procedure if exists obtenerPedidosClienteBodega;
delimiter //
create procedure obtenerPedidosClienteBodega (IN idBodega int)
Begin
	SELECT Pedido.idPedido, Pedido.estado, pedido_cliente.idCliente
	FROM Bodega
	INNER JOIN Pedido ON Pedido.idBodega=Bodega.idBodega and Bodega.idBodega=idBodega
    INNER JOIN pedido_cliente ON pedido_cliente.idPedido=Pedido.idPedido;
End //
delimiter ;


drop procedure if exists obtenerCliente;
delimiter //
create procedure obtenerCliente (IN idCliente varchar(10))
Begin
	SELECT clientes.idCliente, clientes.nombres, clientes.apellidos, clientes.email, clientes.direccion, clientes.numero
	FROM clientes
	WHERE clientes.idCliente=idCliente;
End //
delimiter ;

drop procedure if exists ped_actualizarEstado;
delimiter //
create procedure ped_actualizarEstado(IN idpedido int, idrepartidor char(10), estado char(15))
Begin
	update pedido set idRepartidor=idrepartidor,estado=estado where idPedido=idpedido;
End //
delimiter ;

drop procedure if exists obtenerRepartidor;
delimiter //
create procedure obtenerRepartidor(IN idrepartidor char(10))
Begin
	select empleados.Cedula, empleados.nombres, empleados.apellidos
    from repartidor_bodega
    INNER JOIN empleados ON empleados.Cedula=repartidor_bodega.idRepartidor and repartidor_bodega.idRepartidor=idrepartidor;
End //
delimiter ;

drop procedure if exists obtenerBodegaPorProducto;
delimiter //
create procedure obtenerBodegaPorProducto(IN idProducto int, cantidad int)
Begin
	select productos_bodega.idBodega
    from productos_bodega
    where productos_bodega.idProducto=idProducto and productos_bodega.cantidad=cantidad;
End //
delimiter ;

drop procedure if exists actualizarBodegaPorProducto;
delimiter //
create procedure actualizarBodegaPorProducto(IN idBodega int,idProducto int, cantidad int)
Begin
	update productos_bodega 
    set productos_bodega.cantidad=cantidad 
    where productos_bodega.idBodega=idBodega and productos_bodega.idProducto=idProducto;
End //
delimiter ;

drop procedure if exists obtenerLocalporGerente;
delimiter //
create procedure obtenerLocalporGerente(IN idGerente char(10))
Begin
	select gerente.idSucursal
    from gerente
    where gerente.idGerente=idGerente;
End //
delimiter ;

drop procedure if exists insertarPedido;
delimiter //
create procedure insertarPedido(IN idPedido int, idBodega int, estado char(10))
Begin
	Insert into pedido values (idPedido,null,idBodega,estado,null,null,0);
End //
delimiter ;

drop procedure if exists insertarProductoPedido;
delimiter //
create procedure insertarProductoPedido(IN idPedido int, idProducto int, cantidad int)
Begin
	Insert into productos_pedido values (idProducto,idPedido,cantidad);
End //
delimiter ;

drop procedure if exists insertarProductoLocal;
delimiter //
create procedure insertarProductoLocal(IN idPedido int, idLocal int)
Begin
	Insert into pedido_sucursal values (idPedido,idLocal);
End //
delimiter ;


