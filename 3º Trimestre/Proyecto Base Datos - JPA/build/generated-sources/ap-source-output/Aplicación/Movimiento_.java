package Aplicación;

import Aplicación.TarjetaCredito;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-18T13:35:02", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Movimiento.class)
public class Movimiento_ { 

    public static volatile SingularAttribute<Movimiento, LocalDateTime> fecha;
    public static volatile SingularAttribute<Movimiento, TarjetaCredito> tarjetaCredito;
    public static volatile SingularAttribute<Movimiento, String> concepto;
    public static volatile SingularAttribute<Movimiento, Integer> id;
    public static volatile SingularAttribute<Movimiento, Double> cantidad;

}