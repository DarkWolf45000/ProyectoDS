use DBProyecto;

drop procedure if exists verificar;
delimiter //
create procedure verificar (IN usuarios char(10), contraseña char(10))
Begin
	Select usuario,clave from cuentas where usuario=usuarios and clave=contraseña;
End //

drop procedure if exists buscar_categoria;
delimiter //
create procedure buscar_categoria (IN categoria char(10))
Begin
	Select nombre,categoria,descripcion,precio from producto where categoria=categoria and eliminado=0;
End //

drop procedure if exists buscar_nombre;
delimiter //
create procedure buscar_nombre (IN nombre char(10))
Begin
	Select nombre,categoria,descripcion,precio from producto where nombre=nombre and eliminado=0;
End //

drop procedure if exists buscar_descripcion;
delimiter //
create procedure buscar_descripcion (IN descripcion char(10))
Begin
	Select nombre,categoria,descripcion,precio from producto where descripcion=descripcion and eliminado=0;
End //

drop procedure if exists dar_admin;
delimiter //
create procedure dar_admin (IN cedula char(10), idSuc int)
Begin
	Insert into administrador values (cedula,idSuc);
End //
