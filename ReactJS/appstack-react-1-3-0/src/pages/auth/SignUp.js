import React, { useState } from "react";
import { ReactstrapInput } from "reactstrap-formik";
import { FastField, Formik, Form } from "formik";
import * as Yup from 'yup';
import UserApi from '../api/UserApi'
import { withRouter } from "react-router-dom";

import {
  Button,
  Card,
  CardBody,
  FormGroup,
  Modal,
  ModalBody,
  ModalFooter,
  ModalHeader,
} from "reactstrap";


const SignUp = (props) => {
  const [isOpenModal, setOpenModal] = useState(false);
  const [email, setEmail] = useState("");
  const [isDisableReSendButton, setDisableReSendButton] = useState(false);


  const resendEmail = async () => {
    setDisableReSendButton(true);
    await UserApi.reSendEmail(email);
    setDisableReSendButton(false);
  }

  const reDirectToLogin = () => {
    props.history.push("/auth/sign-in")
  }


  return (
    <>
      <div className="text-center mt-4">
        <h1 className="h2">Get started</h1>
        <p className="lead">
          Create account to experience the course at <b>VTI Academy</b>
        </p>
      </div>

      <Formik
        initialValues={
          {
            firstName: '',
            lastName: '',
            userName: '',
            email: '',
            password: '',
            confirmPassword: ''
          }
        }
        validationSchema={
          Yup.object({
            firstName: Yup.string()
              .max(50, 'Must be less than 50 characters')
              .required('Required'),

            lastName: Yup.string()
              .max(50, 'Must be less than 50 characters')
              .required('Required'),

            userName: Yup.string()
              .min(6, 'Must be between 6 to 50 characters')
              .max(50, 'Must be between 6 to 50 characters')
              .required('Required')
              .test('checkUniqueuserName', 'This UserName has already exist', async username => {
                const isExists = await UserApi.existUserName(username);
                console.log(isExists);
                return !isExists;
              }),

            email: Yup.string()
              .email('Invalid email address')
              .required('Required')

              //call api
              .test('checkUniqueEmail', 'This email has already exist', async email => {
                const isExists = await UserApi.existByEmail(email);
                console.log(isExists);
                return !isExists;
              })
            ,

            password: Yup.string()
              .min(5, 'Must be between 5 to 50 characters')
              .max(50, 'Must be between 5 to 50 characters')
              .required('Required'),

            confirmPassword: Yup.string().when("password", {
              is: val => (val && val.length > 0 ? true : false),
              then: Yup.string().oneOf(
                [Yup.ref("password")],
                "Both password need to be the same"
              )
            })
          })}

        onSubmit={async (values) => {

          try {
            // call api
            await UserApi.create(
              values.userName,
              values.email,
              values.firstName,
              values.lastName,
              values.password);

            //open module 
            setEmail(values.email);
            setOpenModal(true);

          } catch (error) {

            //Send redirect to error page
            props.history.push("auth/500")
          }
        }

        }

        //dien xong form thi moi validate
        validateOnChange={false}
        validateOnBlur={false}
      >
        {/* isSubmitting la helper cua formik nen can khai bao  */}
        {({ isSubmitting }) => (
          <Card>
            <CardBody>
              <div className="m-sm-4">
                <Form>

                  <FormGroup>
                    <FastField
                      bsSize="lg"
                      label="First Name"
                      type="text"
                      name="firstName"
                      placeholder="Enter your first name"
                      component={ReactstrapInput}
                    />
                  </FormGroup>

                  <FormGroup>
                    <FastField
                      bsSize="lg"
                      label="Last Name"
                      type="text"
                      name="lastName"
                      placeholder="Enter your last name"
                      component={ReactstrapInput}
                    />
                  </FormGroup>

                  <FormGroup>
                    <FastField
                      bsSize="lg"
                      label="UserName"
                      type="text"
                      name="userName"
                      placeholder="Enter your UserName"
                      component={ReactstrapInput}
                    />
                  </FormGroup>

                  <FormGroup>
                    <FastField
                      bsSize="lg"
                      label="Email"
                      type="email"
                      name="email"
                      placeholder="Enter your email"
                      component={ReactstrapInput}
                    />
                  </FormGroup>

                  <FormGroup>
                    <FastField
                      bsSize="lg"
                      label="Password"
                      type="password"
                      name="password"
                      placeholder="Enter password"
                      component={ReactstrapInput}
                    />
                  </FormGroup>

                  <FormGroup>
                    <FastField
                      bsSize="lg"
                      label="Confirm Password"
                      type="password"
                      name="confirmPassword"
                      placeholder="Enter confirm password"
                      component={ReactstrapInput}
                    />
                  </FormGroup>

                  <div className="text-center mt-3">
                    <Button type="submit" disabled={isSubmitting} color="primary" size="lg">
                      Sign up
                  </Button>
                  </div>

                </Form>
              </div>
            </CardBody>
          </Card>
        )}
      </Formik>


      <Modal isOpen={isOpenModal}
      >
        <ModalHeader >
          Confirm your account
              </ModalHeader>
        <ModalBody className=" m-3">
          <p className="mb-0">
            We sent an email to <b>{email}</b>
          </p>

          <p className="mb-0">
            Please check email to active account
          </p>
        </ModalBody>
        <ModalFooter>
          <Button color="success" onClick={resendEmail} disabled={isDisableReSendButton} >
            Resend
                </Button>{" "}
          <Button
            color="success" onClick={reDirectToLogin}
          >
            Login
                </Button>
        </ModalFooter>
      </Modal>
    </>
  )
};

export default withRouter(SignUp);
