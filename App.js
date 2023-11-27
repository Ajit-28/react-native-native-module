import { StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import React, { useEffect, useState } from 'react'
import CustomModule from './src/CustomModule'

export default function App() {
  const [deviceId, setDeviceId] = useState('')

  const handlebtn = () => {
    CustomModule.displaytost();
  }

  useEffect(() => {
    const fetchDeviceId = async () => {
      const id = await CustomModule.getDeviceId()
      setDeviceId(id)
    }
    fetchDeviceId()
  }, [])


  return (
    <View style={{ flex: 1, backgroundColor: 'teal', justifyContent: 'center', alignItems: 'center' }}>
      <Text style={{ fontSize: 20, color: '#fff', fontWeight: '600' }}>Click on button to display the Tost Message</Text>
      <TouchableOpacity
        onPress={handlebtn}
        style={{
          height: 50,
          width: 200,
          backgroundColor: '#fff',
          borderRadius: 50,
          elevation: 4,
          justifyContent: 'center',
          alignItems: 'center',
          marginTop: 20
        }}
      >
        <Text style={{ fontSize: 16, fontWeight: 'bold' }}>Click here</Text>
      </TouchableOpacity>
      <Text style={{ fontSize: 20, color: '#fff', marginTop: 20, lineHeight: 30, letterSpacing: 2 }}> Fetch device id by native module code :- { deviceId } </Text>
    </View>
  )
}

const styles = StyleSheet.create({})