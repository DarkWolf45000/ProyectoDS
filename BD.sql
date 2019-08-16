drop database if exists DBProyecto;
create database DBProyecto;
use DBProyecto;

drop table if exists Cuentas;
create table Cuentas(
  idCuenta int(10),
  usuario varchar(15),
  clave varchar(15), 
  eliminado tinyint(1),
primary key (idCuenta)
);

drop table if exists clientes;
create table clientes(
  idCliente int(10),
  nombres varchar(50),
  apellidos varchar(50),
  edad int(5),
  numero varchar(15),
  email varchar(45),
  direccion varchar(50), 
  eliminado tinyint(1),
primary key (idCliente)
);


drop table if exists empleados;
create table empleados(
  Cedula varchar(10),
  nombres varchar(50),
  apellidos varchar(50),
  edad varchar(10),
  idCuenta integer(10),
primary key (Cedula),
foreign key(idCuenta) references cuentas(idCuenta)
);


drop table if exists sucursal;
create table sucursal(
  idSucursal int(10),
  nombre varchar(50),
  direccion varchar(45),
  matriz tinyint(1),
  primary key (idSucursal)
);


drop table if exists bodega;
create table bodega(
   idBodega int(10),
   direccion varchar(45),
	primary key (idBodega)
);


drop table if exists administrador;
create table administrador(
   idAdministrador varchar(10),
   idSucursal int(10),
   primary key (idAdministrador),
   foreign key(idAdministrador) references empleados(cedula),
   foreign key(idSucursal) references sucursal(idSucursal)
);

drop table if exists gerente;
create table gerente(
   idGerente varchar(10),
   idSucursal int(10),
   primary key (idGerente),
   foreign key(idGerente) references empleados(cedula),
   foreign key(idSucursal) references sucursal(idSucursal)
);

drop table if exists vendedor;
create table vendedor(
   idVendedor varchar(10),
   idSucursal int(10),
   primary key (idVendedor),
   foreign key(idVendedor) references empleados(cedula),
   foreign key(idSucursal) references sucursal(idSucursal)
);

drop table if exists jefebodega;
create table jefebodega(
  idJefe varchar(10),
  idBodega int(10),
primary key (idJefe),
foreign key(idJefe) references empleados(Cedula),
foreign key(idBodega) references bodega(idBodega)
);

drop table if exists repartidor_bodega;
create table repartidor_bodega(
  idRepartidor varchar(10),
  idBodega int(10),
primary key (idRepartidor),
foreign key(idRepartidor) references empleados(Cedula),
foreign key(idBodega) references bodega(idBodega)
);


drop table if exists producto;
create table producto(
	idProducto int(10),
	nombre varchar(50),
	categoria varchar(20),
	descripcion varchar(100),
	precio decimal(10,2),
	eliminado tinyint(1),
	primary key (idProducto)
);

drop table if exists pedido;
create table pedido(
	idPedido int(10),
	idRepartidor varchar(10),
	estado varchar(15),
	HoraSalida Time,
	HoraEntrega Time,
	eliminado tinyint(1),
	primary key (idPedido),
	foreign key(idRepartidor) references repartidor_bodega(idRepartidor)
);

drop table if exists venta;
create table venta(
	idVenta int(10),
	idSucursal varchar(10),
	idCliente varchar(10),
	tipopago varchar(10),
	fecha DATE,
	eliminado tinyint(1),
	primary key (idVenta),
	foreign key(idSucursal) references sucursal(idSucursal),
	foreign key(idCliente) references cliente(idCliente)
);

drop table if exists factura;
create table factura(
	idFactura int(10),
	idVenta varchar(10),
	PrecioTotal decimal(8,2),
	primary key (idFactura),
	foreign key(idVenta) references venta(idVenta)
);

drop table if exists cotizacion;
create table cotizacion(
	idCotizacion int(10),
	idCliente varchar(10),
	idSucursal int(10),
	fecha Date,
	primary key (idCotizacion),
	foreign key(idCliente) references cliente(idCliente),
	foreign key(idSucursal) references sucursal(idSucursal)
);

drop table if exists productos_local;
create table productos_local(
	idProducto int(10),
	idSucursal int(10),
	cantidad int(5),
	primary key(idProducto),
	foreign key(idProducto) references producto(idProducto),
	foreign key(idSucursal) references sucursal(idSucursal)
);

drop table if exists productos_pedido;
create table productos_pedido(
	idProducto int(10),
	idPedido int(10),
	cantidad int(5),
	primary key(idProducto),
	foreign key(idProducto) references producto(idProducto),
	foreign key(idPedido) references pedido(idPedido)
);

drop table if exists pedido_cliente;
create table pedido_cliente(
	idPedido int(10),
	idCliente int(10),
	primary key(idPedido),
	foreign key(idPedido) references pedido(idPedido),
	foreign key(idCliente) references cliente(idCliente)
);

drop table if exists pedido_sucursal;
create table pedido_sucursal(
	idPedido int(10),
	idSucursal int(10),
	primary key(idPedido),
	foreign key(idPedido) references pedido(idPedido),
	foreign key(idSucursal) references sucursal(idSucursal)
);

drop table if exists productos_bodega;
create table productos_bodega(
	idProducto int(10),
	idBodega int(10),
	cantidad int(10),
	primary key(idProducto),
	foreign key(idProducto) references producto(idProducto),
	foreign key(idBodega) references bodega(idBodega)
);

drop table if exists productos_factura;
create table productos_factura(
	idProducto int(10),
	idFactura int(10),
	cantidad int(10),
	primary key(idProducto),
	foreign key(idProducto) references producto(idProducto),
	foreign key(idFactura) references factura(idFactura)
);

Insert into Cuentas values (1,"dyance","espol1",0),
							(2,"lsalazar","espol2",0),
							(3,"csanchez","espol3",0),
							(4,"lpod","espol4",0),
							(5,"podcast","espol5",0);
Insert into clientes values (1,"Bryan","Segovia",20,"1234","b@espol.com","Florida",0),
							(2,"Marco","Tulio",50,"12345","m@espol.com","Guasmo",0),
							(3,"Alicia","Maravilla",40,"8534","a@espol.com","Albonor",0);
Insert into empleados values (0943842997,"Diego","Yance",22,1),
							(0920920920,"Luis","Salazar",21,2),
							(0910910910,"Carlos","Sanchez",22,3),
							(0940940940,"Lucas","Pod",23,4),
							(0950950950,"Lapras","Yoshi",57,5);
Insert into sucursal values (1,"Negocio Suc","Sauces 1",0),
							(2,"Negocio Matr","Alborada 11",1);
Insert into bodega values (1,"Costa Este");							
Insert into administrador values (0943842997,1);
Insert into gerente values (0920920920,1);
Insert into vendedor values (0910910910,1);
Insert into jefebodega values (0940940940,1);
Insert into repartidor_bodega values (0950950950,1);
Insert into producto values (1,"Aromatel","Higiene","Producto para limpiar",1.55,0),
							(2,"Kchitos","Alimentos","Comestible para fiestas",0.25,0),
							(3,"Galak","Alimentos","Comestible dulce",0.70,0),
							(4,"Mi Lechera","Alimentos","Bebida lactea",1.30,0),
							(5,"Club Social","Alimentos","Comestible para fiestas",0.15,0);
Insert into pedido values (1,0950950950,"Entregado",'10:00','11:15',0);
Insert into venta values (1,1,1,"efectivo",'2019-08-15',0);
Insert into factura values (1,1,4.00);
Insert into cotizacion values (1,1,1,'2019-08-13');
Insert into productos_local values (1,1,20),(2,1,15),(3,1,25),(4,1,30),(5,1,35);
Insert into productos_pedido values (1,1,2),(2,1,1),(3,1,2);
Insert into pedido_cliente values (1,1);
Insert into pedido_sucursal values (1,1);
Insert into productos_bodega values (1,1,200),(2,1,150),(3,1,250),(4,1,300),(5,1,350);
Insert into productos_factura values (2,1,10),(4,1,10);
							
															