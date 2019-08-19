drop database if exists DBProyecto;
create database DBProyecto;
use DBProyecto;

drop table if exists Cuentas;
create table Cuentas(
  idCuenta int,
  usuario varchar(15),
  clave varchar(15), 
  eliminado tinyint(1),
primary key (idCuenta)
);

drop table if exists clientes;
create table clientes(
  idCliente varchar(10),
  nombres varchar(50),
  apellidos varchar(50),
  edad int,
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
  idCuenta int,
primary key (Cedula),
foreign key(idCuenta) references Cuentas(idCuenta)
);


drop table if exists sucursal;
create table sucursal(
  idSucursal int,
  nombre varchar(50),
  direccion varchar(45),
  matriz tinyint(1),
  primary key (idSucursal)
);


drop table if exists bodega;
create table bodega(
   idBodega int,
   direccion varchar(45),
	primary key (idBodega)
);


drop table if exists administrador;
create table administrador(
   idAdministrador varchar(10),
   idSucursal int,
   primary key (idAdministrador),
   foreign key(idAdministrador) references empleados(cedula),
   foreign key(idSucursal) references sucursal(idSucursal)
);

drop table if exists gerente;
create table gerente(
   idGerente varchar(10),
   idSucursal int,
   primary key (idGerente),
   foreign key(idGerente) references empleados(cedula),
   foreign key(idSucursal) references sucursal(idSucursal)
);

drop table if exists vendedor;
create table vendedor(
   idVendedor varchar(10),
   idSucursal int,
   primary key (idVendedor),
   foreign key(idVendedor) references empleados(cedula),
   foreign key(idSucursal) references sucursal(idSucursal)
);

drop table if exists jefebodega;
create table jefebodega(
  idJefe varchar(10),
  idBodega int,
primary key (idJefe),
foreign key(idJefe) references empleados(Cedula),
foreign key(idBodega) references bodega(idBodega)
);

drop table if exists repartidor_bodega;
create table repartidor_bodega(
  idRb int not null auto_increment,
  idRepartidor varchar(10),
  idBodega int,
primary key (idRb),
foreign key(idRepartidor) references empleados(Cedula),
foreign key(idBodega) references bodega(idBodega)
);


drop table if exists producto;
create table producto(
	idProducto int,
	nombre varchar(50),
	categoria varchar(20),
	descripcion varchar(100),
	precio decimal(10,2),
	eliminado tinyint(1),
	primary key (idProducto)
);

drop table if exists pedido;
create table pedido(
	idPedido int,
	idRepartidor varchar(10),
    idBodega int,
	estado varchar(15),
	HoraSalida Time,
	HoraEntrega Time,
	eliminado tinyint(1),
	primary key (idPedido),
	foreign key(idRepartidor) references repartidor_bodega(idRepartidor),
    foreign key(idBodega) references bodega(idBodega)
);

drop table if exists venta;
create table venta(
	idVenta int,
	idSucursal int,
	idCliente varchar(10),
	tipopago varchar(10),
	fecha DATE,
	eliminado tinyint(1),
	primary key (idVenta),
	foreign key(idSucursal) references sucursal(idSucursal),
	foreign key(idCliente) references clientes(idCliente)
);

drop table if exists factura;
create table factura(
	idFactura int,
	idVenta int,
	PrecioTotal decimal(8,2),
	primary key (idFactura),
	foreign key(idVenta) references venta(idVenta)
);

drop table if exists cotizacion;
create table cotizacion(
	idCotizacion int,
	idCliente varchar(10),
	idSucursal int,
	fecha Date,
	primary key (idCotizacion),
	foreign key(idCliente) references clientes(idCliente),
	foreign key(idSucursal) references sucursal(idSucursal)
);

drop table if exists productos_local;
create table productos_local(
	idPl int not null auto_increment,
	idProducto int,
	idSucursal int,
	cantidad int,
	primary key(idPl),
	foreign key(idProducto) references producto(idProducto),
	foreign key(idSucursal) references sucursal(idSucursal)
);

drop table if exists productos_pedido;
create table productos_pedido(
	idPp int not null auto_increment,
	idProducto int,
	idPedido int,
	cantidad int,
	primary key(idPp),
	foreign key(idProducto) references producto(idProducto),
	foreign key(idPedido) references pedido(idPedido)
);

drop table if exists pedido_cliente;
create table pedido_cliente(
	idPc int not null auto_increment,
	idPedido int,
	idCliente varchar(10),
	primary key(idPc),
	foreign key(idPedido) references pedido(idPedido),
	foreign key(idCliente) references clientes(idCliente)
);

drop table if exists pedido_sucursal;
create table pedido_sucursal(
	idPs int not null auto_increment,
	idPedido int,
	idSucursal int,
	primary key(idPs),
	foreign key(idPedido) references pedido(idPedido),
	foreign key(idSucursal) references sucursal(idSucursal)
);

drop table if exists productos_bodega;
create table productos_bodega(
	idPb int not null auto_increment,
	idProducto int,
	idBodega int,
	cantidad int,
	primary key(idPb),
	foreign key(idProducto) references producto(idProducto),
	foreign key(idBodega) references bodega(idBodega)
);

drop table if exists productos_factura;
create table productos_factura(
	idPf int not null auto_increment,
	idProducto int,
	idFactura int,
	cantidad int,
	primary key(idPf),
	foreign key(idProducto) references producto(idProducto),
	foreign key(idFactura) references factura(idFactura)
);


															