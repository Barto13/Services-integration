import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException, InvalidName, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound {
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

        //usluga nazwowa
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        NamingContext ncRef = NamingContextHelper.narrow(objRef);
        NameComponent nc = new NameComponent("Arytmetyka", "");
        NameComponent path[] = {nc};

        ArytmetykaServant as = new ArytmetykaServant();
        orb.connect(as);

        ncRef.rebind(path, as);



        //usluga nazwowa
        org.omg.CORBA.Object objRef1 = orb.resolve_initial_references("NameService");
        NamingContext ncRef1 = NamingContextHelper.narrow(objRef1);
        NameComponent nc1 = new NameComponent("Bookstore", "");
        NameComponent path1[] = {nc1};

        BookstoreServant bs = new BookstoreServant();
        orb.connect(bs);

        ncRef1.rebind(path1, bs);

//        PrintWriter out = new PrintWriter(new BufferedWriter(
//                new FileWriter("ref.ior")));
//        out.println(
//                orb.object_to_string(as) );
//        out.close();

        java.lang.Object sync = new java.lang.Object();
        synchronized(sync) {sync.wait();}
    }
}
