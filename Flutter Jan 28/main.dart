import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);


  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  
  String value = "assets/a.jpg";
   var array = ["assets/a.jpg","assets/b.jpg"];
   int counter = 1;
  @override
  Widget build(BuildContext context) {
  
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Column(
          children: [
            Image.asset(value),
            RaisedButton(child:Text("Click me"),onPressed:(){
                setState(() {
                  value = array[counter];
                  if(counter==1)
                  {
                    counter=0;
                  }
                  else
                  {
                    counter=1;
                  }
                });
            })
          
          ],
      ),
     
    );
  }
}
