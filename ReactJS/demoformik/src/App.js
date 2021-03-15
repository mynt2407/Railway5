import './App.css';
import SignupFormik from './formikTag/VD1/SignUpForm';
import SignupFormikWithForm from './formikTag/VD2/SignUpForm';
import SignupFormikSelector from './formikTag/VD3/SignUpForm';
import SignupFormikApi from './formikTag/VD5/component/SignupForm';
import Container from "./withFormik/SignUpFormCointainer"
import SignUpYup from './Yup/VD1/SignUpFormYup';
function App() {
  return (
    <div>
      {/* <SignupFormApi/> */}
      {/* <SignupFormFromServe/> */}
      {/* <Container /> */}
      {/* <SignupFormik/> */}
      {/* <SignupFormikWithForm/> */}
      {/* <SignupFormikSelector/> */}
      {/* <SignupFormikApi/> */}
      <SignUpYup />

    </div>
  );
}

export default App;
