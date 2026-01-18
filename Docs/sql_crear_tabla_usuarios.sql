-- ========================================
-- Script SQL para crear tabla de usuarios
-- Base de datos: PostgreSQL (Neon)
-- ========================================

-- Crear tabla de usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    rol VARCHAR(50) NOT NULL DEFAULT 'ADMIN'
);

-- ========================================
-- OPCIÓN 1: Dejar que la aplicación cree el usuario automáticamente
-- ========================================
-- Si usas el DataInitializer.java, la aplicación creará el usuario
-- automáticamente al iniciar si no existe. NO necesitas ejecutar
-- el INSERT de abajo.

-- ========================================
-- OPCIÓN 2: Insertar el usuario manualmente
-- ========================================
-- Si prefieres insertar el usuario manualmente, usa este INSERT.
-- La contraseña "Secreta655%" ya está hasheada con BCrypt.

INSERT INTO usuarios (email, password, rol) VALUES (
    'megawhitegengar@gmail.com',
    '$2a$10$N9qo8uLOickgx2ZMRZoMy.Mrq4H9Q0q5aTvPxGHvl/Zy3GQQ6O1pu',
    'ADMIN'
) ON CONFLICT (email) DO NOTHING;

-- ========================================
-- Notas sobre el hash BCrypt:
-- ========================================
-- El hash de arriba fue generado con BCrypt para la contraseña "Secreta655%"
-- Si necesitas generar otro hash, puedes usar:
-- - Online: https://bcrypt-generator.com/
-- - Java: new BCryptPasswordEncoder().encode("tu_password")
-- 
-- IMPORTANTE: El hash BCrypt siempre es diferente aunque sea la misma contraseña
-- porque incluye un "salt" aleatorio. Cualquier hash válido funcionará.

-- ========================================
-- Verificar que el usuario existe:
-- ========================================
-- SELECT id, email, rol FROM usuarios WHERE email = 'megawhitegengar@gmail.com';
