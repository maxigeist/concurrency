use std::fmt::Debug;
use std::rc::Rc;
use std::thread;

fn hello(n:u32) {
    let x = "xxx".to_string();
    thread::scope(|s|{
        s.spawn(|| println!("Hello from thread 1 {x}"));
        s.spawn(|| println!("Hello from thread 2 {x}"));
    })

        //     )
    // }

    // for t in threads{
    //     t.join().unwrap()
    // }

}

fn main() {

    hello(10);
    println!("====== Good Bye Threads =======");



    // uncomment me! thread::sleep(Duration::from_secs(1));


    // let queue = Mutex::new(VecDeque::new());
    // let not_empty = Condvar::new();
    //
    // thread::scope(|s| {
    //     s.spawn(|| {
    //         loop {
    //             let mut q = queue.lock().unwrap(); //bloqueo la cola
    //             match q.pop_front{
    //                 Some(item) => {
    //                     println!("Popped: {item}")
    //                 }
    //                 None => {
    //                     println!("Try again");
    //                     not_empty.wait(q); //se queda esperando hasta que alguien avise que puso algo
    //                 }
    //             }
    //
    //             if let Some(item) = q.pop_front() {
    //                 println!("Popped: {item}", );
    //             }
    //         }
    //     });
    //
    //     for i in 0.. {
    //         queue.lock().unwrap().push_back(i); //Para alguien poder agregar algo va a tener que lockear la cola
    //         not_empty.notify_one(); //Acá resto uno para que pueda seguir corriendo
    //         thread::sleep(Duration::from_secs(1));
    //     }
    // });
}
