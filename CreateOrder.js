import React from 'react';

import {
  ChakraProvider,
  Button,
  theme,
  Modal,
  ModalOverlay,
  ModalContent,
  ModalHeader,
  ModalCloseButton,
  ModalBody,
  FormControl,
  FormLabel,
  ModalFooter,
  useDisclosure,
  Select,
  NumberInput,
  NumberInputField,
  NumberInputStepper,
  NumberIncrementStepper,
  NumberDecrementStepper,
  Input,

} from '@chakra-ui/react';

import {  useLocation} from 'react-router-dom';
import{useState} from'react';
import Navbar from '../component/Navbar';
function CreateOrder() {

  const { isOpen, onOpen, onClose } = useDisclosure()
  
  const initialRef = React.useRef(null)
   const finalRef = React.useRef(null)
  const formOrder = useLocation();
  //let provider = formOrder.state.providerName; //id profile from majd page 
  const [date, setDate] = useState("");
  const [time, setTime] = useState("");
  const handleDateChange = (event) => setDate(event.target.value)
  const [hour, setHour] = useState(1);
  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");

  
  // const username = 'no';
  // const password = '123';

  // myHeaders.append('Authorization', 'Basic ' + btoa(username + ":" + password));

  var raw = JSON.stringify({
    "hrId": 1,
    "numberOfHours": hour,
    "date": date,
    "time": time,
});


var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
};
const sendAppointmentData = async () => {
const request = await fetch("/api/v1/auth/meet", requestOptions);
const data =  request.json();
console.log(data);
            console.log(data.message)
                setDate("");
               
}
  //fetch

  const BookAppointment = async (e) => {
    sendAppointmentData();
}
  return (
    <ChakraProvider theme={theme}>
        <Navbar/>

 <Button onClick={onOpen}>Reservation</Button>

      <Modal
        initialFocusRef={initialRef}
        finalFocusRef={finalRef}
        isOpen={isOpen}
        onClose={onClose}
      >
        
        <ModalOverlay />
        <ModalContent>
          <ModalHeader>Create your account</ModalHeader>
          <ModalCloseButton />
          <ModalBody pb={6}>

          <FormControl>
          <FormLabel>Select Date:</FormLabel>
      <Input
                              value={date}
                              min={new Date().toISOString().slice(0, 16)}
                              onChange={handleDateChange}
       placeholder="Select Date and Time"
           size="md"
          type="datetime-local"
 
/>
      </FormControl>
       
   
      <FormControl>
      <FormLabel>Number of Hours:</FormLabel>
      <NumberInput                   onChange={setHour}
                        value={hour} max={4} min={1}>
      <NumberInputField />
      <NumberInputStepper>
      <NumberIncrementStepper />
      <NumberDecrementStepper />
      </NumberInputStepper>
      </NumberInput>
      </FormControl>
          </ModalBody>

          <ModalFooter>
            <Button onClick={BookAppointment} colorScheme='blue' mr={3}>
              Send
            </Button>
            <Button onClick={onClose}>Cancel</Button>
          </ModalFooter>
        </ModalContent>
      </Modal>
    </ChakraProvider>
  );
}

export default CreateOrder;