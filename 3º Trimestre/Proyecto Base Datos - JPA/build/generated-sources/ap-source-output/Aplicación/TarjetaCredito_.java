package Aplicación;

import Aplicación.Movimiento;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-18T13:35:02", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(TarjetaCredito.class)
public class TarjetaCredito_ { 

    public static volatile SingularAttribute<TarjetaCredito, LocalDate> fecha;
    public static volatile SingularAttribute<TarjetaCredito, Double> gastado;
    public static volatile SingularAttribute<TarjetaCredito, String> pin;
    public static volatile SingularAttribute<TarjetaCredito, String> numero;
    public static volatile SingularAttribute<TarjetaCredito, String> nif;
    public static volatile ListAttribute<TarjetaCredito, Movimiento> movimientos;
    public static volatile SingularAttribute<TarjetaCredito, Integer> limite;
    public static volatile SingularAttribute<TarjetaCredito, String> nombre;

}