use empleosdb;

SELECT * FROM empleosdb.categorias;

INSERT INTO empleosdb.categorias (id, nombre, descripcion) VALUES
(1, 'Arquitectura', 'Habilidades para diseñar, dirigir y construir proyectos arquitectónicos, desde casas hasta el planeamiento de una ciudad.'),
(2, 'Ingeniería de Software', 'Conocimientos en desarrollo, diseño, prueba y mantenimiento de sistemas de software.'),
(3, 'Medicina', 'Diagnóstico, tratamiento y prevención de enfermedades en pacientes humanos.'),
(4, 'Diseño Gráfico', 'Uso de herramientas digitales y creativas para crear contenido visual atractivo.'),
(5, 'Marketing Digital', 'Estrategias para promocionar productos o servicios mediante medios digitales.'),
(6, 'Contabilidad', 'Gestión y análisis de registros financieros de empresas y organizaciones.'),
(7, 'Educación', 'Planificación e implementación de métodos de enseñanza y aprendizaje.'),
(8, 'Logística', 'Coordinación del transporte, almacenamiento y distribución de productos.'),
(9, 'Derecho', 'Conocimientos jurídicos para representar y asesorar legalmente a personas o empresas.'),
(10, 'Psicología', 'Estudio del comportamiento humano y aplicación de técnicas para el bienestar mental.');

select * from vacantes;
describe vacantes;
alter table vacantes drop column idCategoria;

SHOW CREATE TABLE vacantes;
ALTER TABLE vacantes DROP FOREIGN KEY fk_vacantes_categorias1;
ALTER TABLE vacantes DROP COLUMN idCategoria;


INSERT INTO vacantes (nombre, descripcion, fecha, salario, estatus, destacado, imagen, detalles, description, id_categoria) VALUES
('Desarrollador Java', 'Desarrollador backend con experiencia en Java y Spring Boot.', NOW(), 85000.00, 'Activa', 1, 'java.png', 'Trabajo remoto disponible', 'Java backend developer', 1),
('Diseñador Gráfico', 'Diseño de materiales digitales e impresos.', NOW(), 45000.00, 'Activa', 0, 'diseno.png', 'Conocimiento en Adobe Suite', 'Graphic designer', 2),
('Analista de Datos', 'Análisis de datos y creación de dashboards.', NOW(), 70000.00, 'Activa', 1, 'datos.png', 'Uso de Power BI y SQL', 'Data analyst', 3),
('Administrador de Redes', 'Gestión de infraestructura de red y servidores.', NOW(), 60000.00, 'Activa', 0, 'redes.png', 'Conocimiento en Cisco y Linux', 'Network administrator', 4),
('Desarrollador Frontend', 'Implementación de interfaces con React y Vue.', NOW(), 80000.00, 'Activa', 1, 'frontend.png', 'Responsive design', 'Frontend developer', 1),
('Soporte Técnico', 'Atención a usuarios y mantenimiento de equipos.', NOW(), 35000.00, 'Inactiva', 0, 'soporte.png', 'Trabajo presencial', 'IT support', 5),
('Marketing Digital', 'Gestión de campañas en redes y Google Ads.', NOW(), 50000.00, 'Activa', 0, 'marketing.png', 'Experiencia en SEO/SEM', 'Digital marketing', 6),
('Product Manager', 'Gestión de ciclo de vida de productos digitales.', NOW(), 95000.00, 'Activa', 1, 'product.png', 'Agile/Scrum', 'Product manager', 7),
('QA Tester', 'Pruebas manuales y automatizadas de software.', NOW(), 55000.00, 'Activa', 0, 'qa.png', 'Selenium, JUnit', 'Software tester', 8),
('Scrum Master', 'Facilitador de equipos ágiles, seguimiento de sprints.', NOW(), 90000.00, 'Activa', 1, 'scrum.png', 'Certificación Scrum', 'Scrum master', 7);

select * from perfiles;
describe usuarioperfil;
select * from usuario_perfil;
select * from usuarios;
