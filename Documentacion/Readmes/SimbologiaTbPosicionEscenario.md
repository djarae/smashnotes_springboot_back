# Para las posiciones comunes , elñ campo IdPosicionComun y el campo “VerticalHorizontal” forman una “clave compuesta” para identificar las posciones mas comunes:

0: Posicion No Comun 
idPosicionComun >0  => Si la posición común es mayor a 0 , signifca que es una posición común, sino lo es , es algo agregado y especifico
Vertical(0) + idPosicionComun1=> Plataforma principal . Vertical . verticalHorizontal 
Vertical(0) + idPosicionComun2 Plataforma 1 : Media . Aplica para todas menos Final destination => VerticalHorizontal =>0
Vertical(0) + idPosicionComun3 Plataforma 2 : Alta . Aplica solo para BF & Town and City,
Horizontal(1)+ idPosiconComun1 => Esquina escenario
Horizontal(1)+ idPosiconComun2 => Ledge Roll oponente
Horizontal(1)+idPosiconComun3=> Centro Escenario
Horizontal(1)+idPosicionComun4=>Esquina Contraria
