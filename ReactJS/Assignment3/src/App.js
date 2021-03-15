import HomePage2 from './Layout2Way.js/HomPage2';
import './App.css';
import event from './event';
import FlavorForm from './FlavorForm';
import Fragment from './fragment';
import NameForm from './NameForm';
import Person from './person';
import Person2 from './Person2';
import ReadMore from './ReadMore';
import Clock from './State';
import Table from './Table';
import Table1 from './Table1';
import Table2 from './Table2';
import DeletePerson from './DeletePerson/DeletePerson';
import DeleteListMentee from './DeletePerson/DeleteListMentee';
//import Blink from './Blink/Blinkabc';


function App() {

  const divStyle = {
    color: 'red'
  };
  const divBorder = {
    border: 'solid 1px green'
  }

  const handlerClickDiv = () => {
    console.log("Hello");
  }

  return (
    <div>
      {/* Hello World */}
      <div style={divStyle} onClick={handlerClickDiv}>Hello World</div>

      {/* Question 2b */}

      <h1> Hello World</h1>
      <p>My first paragraph</p>

      <h2>DANH SÁCH LỚP HỌC</h2>

      <ol>
        <li>Nguyễn Ngọc Duy</li>
        <li>Tống Quang Anh</li>
        <li>Đinh Thu Loan</li>
        <li>Hà Văn Tiến</li>
        <li>Nguyễn Hải Đăng</li>
        <li>Nguyễn Tiến Quang</li>
        <li>Nguyễn Chiến Thắng</li>
      </ol>

      {/* Cách 1 */}
      <div className="App">Hello World1</div>
      <br></br>

      {/* Cach 2 */}
      <div style={divBorder}>Hello World2</div>


      <div>
        <Person />
        <Person />
        <Person />
      </div>

      <Clock />
      <br />

      <Table1 />
      <br />

      <NameForm />
      <br />

      <Fragment />
      <br />

      <Person2 />
      <br />

      <FlavorForm />
      <br />

      <event.Event1 />
      <br />

      <event.Event2 />
      <br />

      <DeletePerson />
      <br />

      {/* <Blink /> */}

      {/* <event.Event3 /> */}
      <br />

      <ReadMore />
      <br />

      <DeleteListMentee />
      <br />

      
      <Table2 />
      <br />

      <HomePage2 />

    </div>
  );
}

export default App;