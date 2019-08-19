use DBProyecto;

#Valores introducidos en tablas

Insert into Cuentas values (1,"dyance","espol1",0),
							(2,"lsalazar","espol2",0),
							(3,"csanchez","espol3",0),
							(4,"lpod","espol4",0),
							(5,"podcast","espol5",0),
							(6,"mamadisimo","espol6",0),
							(7,"bysua","espol7",0),
							(8,"sanlo","espol8",0);
                            
Insert into clientes values ("1","Bryan","Segovia",20,"1234","b@espol.com","Florida",0),
							("2","Marco","Tulio",50,"12345","m@espol.com","Guasmo",0),
							("3","Alicia","Maravilla",40,"8534","a@espol.com","Albonor",0);
                            
Insert into empleados values ("0943842997","Diego","Yance",22,1),
							("0920920920","Luis","Salazar",21,2),
							("0910910910","Carlos","Sanchez",22,3),
							("0940940940","Lucas","Pod",23,4),
							("0950950950","Lapras","Yoshi",57,5),
							("0933452254","Michael","Perez",30,6),
							("0979845447","Byron","Suarez",32,7),
							("0933654410","Sandro","Lopez",31,8);
                            
Insert into sucursal values (1,"Negocio Suc","Sauces 1",0),
							(2,"Negocio Matr","Alborada 11",1);
                            
Insert into bodega values (1,"Costa Este");							

Insert into administrador values ("0943842997",1);

Insert into gerente values ("0920920920",1);

Insert into vendedor values ("0910910910",1);

Insert into jefebodega values ("0940940940",1);

Insert into repartidor_bodega values (1,"0950950950",1),
									 (2,"0933452254",1),
									 (3,"0979845447",1),
									 (4,"0933654410",1);

Insert into producto values (1,"Aromatel","Higiene","Producto para limpiar",1.55,0),
							(2,"Kchitos","Alimentos","Comestible para fiestas",0.25,0),
							(3,"Galak","Alimentos","Comestible dulce",0.70,0),
							(4,"Mi Lechera","Alimentos","Bebida lactea",1.30,0),
							(5,"Club Social","Alimentos","Comestible para fiestas",0.15,0);
                            
Insert into pedido values (1,"0950950950",1,"Entregado",'10:00','11:15',0);
Insert into pedido values (2,"0950950950",1,"Entregado",'10:00','11:15',0);
Insert into pedido values (3,"0933452254",1,"A Entregar",'14:00','14:30',0);
Insert into pedido values (4,"0979845447",1,"No Entregado",'10:00','0:0',0);
Insert into pedido values (5,"0933654410",1,"No Recibido",'10:00','0:0',0);
Insert into pedido values (6,"0933452254",1,"Perdido",'10:00','0:0',0);

Insert into venta values (1,1,"1","efectivo",'2019-08-15',0);

Insert into factura values (1,1,4.00);

Insert into cotizacion values (1,1,"1",'2019-08-13');

Insert into productos_local values (1,1,1,20),(2,2,1,15),(3,3,1,25),(4,4,1,30),(5,5,1,35);

Insert into productos_pedido values (1,1,1,2),(2,2,1,1),(3,3,1,2);

Insert into pedido_cliente values (1,1,"1");

Insert into pedido_sucursal values (1,2,1);

Insert into productos_bodega values (1,1,1,200),(2,2,1,150),(3,3,1,250),(4,4,1,300),(5,5,1,350);

Insert into productos_factura values (1,2,1,10),(2,4,1,10);
							