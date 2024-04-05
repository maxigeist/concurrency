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
}
