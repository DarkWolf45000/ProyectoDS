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
	idSucursal int(10),
	idCliente int(10),
	tipopago varchar(10),
	fecha DATE,
	eliminado tinyint(1),
	primary key (idVenta),
	foreign key(idSucursal) references sucursal(idSucursal),
	foreign key(idCliente) references clientes(idCliente)
);

drop table if exists factura;
create table factura(
	idFactura int(10),
	idVenta int(10),
	PrecioTotal decimal(8,2),
	primary key (idFactura),
	foreign key(idVenta) references venta(idVenta)
);

drop table if exists cotizacion;
create table cotizacion(
	idCotizacion int(10),
	idCliente int(10),
	idSucursal int(10),
	fecha Date,
	primary key (idCotizacion),
	foreign key(idCliente) references clientes(idCliente),
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
	foreign key(idCliente) references clientes(idCliente)
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


															