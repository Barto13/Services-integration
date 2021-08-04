package edu.pja.sri.lab06.server;

import edu.pja.sri.lab06.BookManager;
import edu.pja.sri.lab06.BookManager_2;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;


public class BookManagerServer {

    public static BookManagerHandler handler;

    public static BookManager.Processor processor;

    public static void main(String [] args) {
//        try {
//            handler = new BookManagerHandler();
//            processor = new BookManager.Processor(handler);
//
//            Runnable simple = new Runnable() {
//                public void run() {
//                    simple(processor);
//                }
//            };
//
//            new Thread(simple).start();
//        } catch (Exception x) {
//            x.printStackTrace();
//        }

        try {
            int port = 9090;
            TMultiplexedProcessor processor = new TMultiplexedProcessor();
            TServerTransport t = new TServerSocket(port);
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(t).processor(processor));
            processor.registerProcessor("BookManagerService1", new  BookManager.Processor<BookManager.Iface>(new BookManagerHandler()));
            processor.registerProcessor("BookManagerService2", new  BookManager_2.Processor<BookManager_2.Iface>(new BookManagerHandler_2()));

            System.out.println("starting server port:" + port);
            server.serve();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void simple(BookManager.Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));

            System.out.println("Starting the simple server...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}