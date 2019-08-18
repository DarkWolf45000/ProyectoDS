use DBProyecto;


drop procedure if exists verificar;
delimiter //
create procedure verificar (IN usuarios char(10), contraseña char(10))
Begin
	Select usuario,clave from cuentas where usuario=usuarios and clave=contraseña;
End //
delimiter ;


drop procedure if exists buscar_categoria;
delimiter //
create procedure buscar_categoria (IN categoria char(10))
Begin
	Select nombre,categoria,descripcion,precio from producto where categoria=categoria and eliminado=0;
End //
delimiter ;

drop procedure if exists buscar_nombre;
delimiter //
create procedure buscar_nombre (IN nombre char(10))
Begin
	Select nombre,categoria,descripcion,precio from producto where nombre=nombre and eliminado=0;
End //
delimiter ;

drop procedure if exists buscar_descripcion;
delimiter //
create procedure buscar_descripcion (IN descripcion char(10))
Begin
	Select nombre,categoria,descripcion,precio from producto where descripcion=descripcion and eliminado=0;
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
	select idRepartidor,estado,HoraSalida,HoraEntrega from pedido where idPedido=idpedido and eliminado=0;
End //
delimiter ;

drop procedure if exists repartidor_bodega;
delimiter //
create procedure repartidor_bodega (IN idbodega int)
Begin
	select empleados.cedula, empleados.nombres, empleados.apellidos, empleados.edad
    from repartidor_bodega
			inner join
		empleados on repartidor_bodega.idRepartidor = empleados.cedula
	where
		repartidor_bodega.idBodega=idbodega
	order by empleados.apellidos;
End //
delimiter ;

drop procedure if exists ped_actualizar;
delimiter //
create procedure ped_actualizar (IN idpedido int, idrepartidor char(10),idbodega int, estado char(15),horasal time,horaent time)
Begin
	update pedido set idRepartidor=idrepartidor,idBodega=idbodega,estado=estado,HoraSalida=horasal,HoraEntrada=horaent where idPedido=idpedido;
End //
delimiter ;	

drop procedure if exists obtenerAdmins;
delimiter //
create procedure obtenerAdmins (IN usuarios char(10), contraseña char(10))
Begin
	SELECT Empleados.cedula, Empleados.nombres, Empleados.apellidos
	FROM Empleados
	INNER JOIN Cuentas ON Empleados.idCuenta=Cuentas.idCuenta and Cuentas.usuario=usuarios and Cuentas.clave=contraseña
    INNER JOIN Administrador ON Administrador.idAdministrador=Empleados.cedula;
End //
delimiter ;

drop procedure if exists obtenerGerente;
delimiter //
create procedure obtenerGerente (IN usuarios char(10), contraseña char(10))
Begin
	SELECT Empleados.cedula, Empleados.nombres, Empleados.apellidos
	FROM Empleados
	INNER JOIN Cuentas ON Empleados.idCuenta=Cuentas.idCuenta and Cuentas.usuario=usuarios and Cuentas.clave=contraseña
    INNER JOIN Gerente ON Gerente.idGerente=Empleados.cedula;
End //
delimiter; 

drop procedure if exists obtenerVendedor;
delimiter //
create procedure obtenerVendedor (IN usuarios char(10), contraseña char(10))
Begin
	SELECT Empleados.cedula, Empleados.nombres, Empleados.apellidos
	FROM Empleados
	INNER JOIN Cuentas ON Empleados.idCuenta=Cuentas.idCuenta and Cuentas.usuario=usuarios and Cuentas.clave=contraseña
    INNER JOIN Vendedor ON Vendedor.idVendedor=Empleados.cedula;
End //
delimiter ;

drop procedure if exists obtenerJefeBodega;
delimiter //
create procedure obtenerJefeBodega (IN usuarios char(10), contraseña char(10))
Begin
	SELECT Empleados.cedula, Empleados.nombres, Empleados.apellidos
	FROM Empleados
	INNER JOIN Cuentas ON Empleados.idCuenta=Cuentas.idCuenta and Cuentas.usuario=usuarios and Cuentas.clave=contraseña
    INNER JOIN jefebodega ON Jefebodega.idJefe=Empleados.cedula;
    
End //
delimiter ;

drop procedure if exists obtenerBodega;
delimiter //
create procedure obtenerBodega (IN idJefe char(10))
Begin
	SELECT Bodega.idBodega, Bodega.direccion
	FROM Bodega
	INNER JOIN jefeBodega ON jefeBodega.idJefe=idJefe and jefeBodega.idBodega=Bodega.idBodega;
End //
delimiter ;
