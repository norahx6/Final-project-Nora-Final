import React, { useEffect, useState } from 'react';
import Navbar from '../component/Navbar'
import Sider from '../component/Sider';
import {
  Table,
  Thead,
  Tbody,
  Tr,
  Th,
  Td,
  TableContainer,
  ChakraProvider,
  Text,
  HStack,
  Flex,
  VStack,
  Box,
  Input,
  Button,
  
} from '@chakra-ui/react'
import { Link } from 'react-router-dom';
import Footer from '../component/Footer';


const Hr=()=>{

  const [ordersList , setOrdersList] = useState([]);

  const url = '/api/v1/auth/meet/by-hr';
  const username = 'lol';
  const password = '123';

  const [link,setLink]=useState('');
  const headers = new Headers();

  headers.set('Authorization', 'Basic ' + btoa(username + ":" + password));
  headers.append("Content-Type", "application/json");

  useEffect(() => {
    const fetchOrdersData = async () => {
      
      const request = await fetch(url, {
      method:'GET',
      headers: headers,
      //credentials: 'user:passwd'
     })
      const data = await request.json();
      console.log(data);
      const ordersMap = data.map((orders) => {
        return {
          id: orders.id,
          date: orders.date,
          time: orders.time,
          numberOfHours : orders.numberOfHours,
          link: orders.link,

        };
      });
      setOrdersList(data);

    };
    fetchOrdersData();
  }, []);

  var raw = JSON.stringify({
    "link": link,
});

// Update Link
var requestOptions = {
    method: 'PUT',
    headers: headers,
    body: raw,
}

  const sendAppointmentData = async (e) => {
  const id=e.target.id;
  console.log(id);
  const request = await fetch("/api/v1/auth/meet/" + id , requestOptions);
  const data =  await request.json();
  //console.log(data);
  //console.log(data.message)
  
  }

  

return (
  <ChakraProvider>

          

<Navbar/>
  <HStack spacing="0" width="100vw" height="100vh"> 
  <Flex justifyContent="center"
  alignItems="center"
  display={['none', 'none', 'flex']}
  backgroundColor="#F9F9FC"
  height="100vh"
  width={['0', '0', '30%']}>
  <VStack mx="auto"
  align="left"
  spacing="5"
  width={['90%', '90%', '458px']}>
<Sider/>
  </VStack>
  </Flex>

<Flex  height="100vh"
  width={['100%', '100%', '50%']}
  justifyContent="center"
  alignItems="space-between"
>
<VStack  mx="auto"
  align="left"
  spacing="8"
  marginTop="10"
  width={['90%', '90%', '700px']}>

<Text textAlign={"center"} fontSize='3xl' fontFamily='Heading Font Name'>Order</Text>
    
  <TableContainer  borderBlock={5} border="solid lightgray"
   w='1000px'>

<Table paddingTop="200" variant='simple'>
  <Thead>
  <Th>Date</Th>
  <Th>Number Of Hours</Th>
  <Th>Link</Th>
  </Thead>
  <Tbody>
  {ordersList.map((order) => ( 
<>
  <Tr></Tr>
  <Td>{order.date}</Td>
  <Td>{order.numberOfHours}</Td>
  <Td> <Input color='teal.500' value={link} onChange={(e)=> setLink(e.target.value)}  placeholder="Enter Link Meeting"></Input>
  <Button onClick={sendAppointmentData} id={order.id} colorScheme={'teal'} variant='link'>Send</Button> </Td>
  <Td></Td>
</>
))}
  </Tbody>
  </Table>
  </TableContainer>
  </VStack>
  </Flex>
  </HStack>
 
  </ChakraProvider>
);
 };
export default Hr;