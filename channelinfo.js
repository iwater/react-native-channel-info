/**
 * @providesModule react-native-channel-info
 */

import { Platform, NativeModules } from 'react-native'
const RNChannelInfo = NativeModules.RNChannelInfo

module.exports = {
  getChannel: function() {
    return (Platform.OS === 'ios') ? 'IAPPSTORE' : RNChannelInfo.Channel;
  }
}