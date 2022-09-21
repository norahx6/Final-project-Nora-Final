import {
  Flex,
  VStack,
  Table,
  Thead,
  Tbody,
  Tr,
  Th,
  Td,
  HStack,
  Text,
  TableContainer,
  Link,
  ChakraProvider,
} from '@chakra-ui/react';
import React, { useEffect, useState } from 'react';
import Navbar from '../component/Navbar';
import Sider from '../component/Sider';

const Nora = () => {

  const [ordersList , setOrdersList] = useState([]);

  const url = '/api/v1/auth/meet';
  const username = 'no';
  const password = '123';

  const headers = new Headers();

  headers.set('Authorization', 'Basic ' + btoa(username + ":" + password));

  useEffect(() => {
      const fetchOrdersData = async () => {
        const request = await fetch(url, {method:'GET',
        headers: headers,
       })
        const data = await request.json();
        console.log(data);
        setOrdersList(data);
      };
      fetchOrdersData();
    }, []);
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
  <Text textAlign={"center"} fontSize='3xl' fontFamily='Heading Font Name'>Order </Text>

  <TableContainer  borderBlock={5} border="solid lightgray"
              
              w='1000px'>
                      <Table paddingTop="200" variant='simple'>
                      <Thead>
                      <Th>Date</Th>
                      <Th>Number Of Hours</Th>
                      <Th>Time</Th>
                      <Th>Link</Th>
                      </Thead>
                      <Tbody>
                      {ordersList.map((order) => ( 
                    <>
                      <Tr></Tr>
                      <Td>{order.date}</Td>
                      <Td>{order.numberOfHours}</Td>
                      <Td>{order.time}</Td>
                      <Td> <Link color='teal.500' href='#'>
                      {order.link}
                      </Link></Td>
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
  
  export default Nora;