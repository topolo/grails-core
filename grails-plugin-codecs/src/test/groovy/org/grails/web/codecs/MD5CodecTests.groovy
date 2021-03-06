package org.grails.web.codecs

import org.grails.plugins.codecs.MD5Codec

class MD5CodecTests extends GroovyTestCase {

    def codec = new MD5Codec()

    void testEncode() {

        def expectedResult = 'ed076287532e86365e841e92bfc50d8c'

        // we want to verify that both array/list and String inputs work
        def primitiveResult = codec.encode([72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 33])
        def toStringResult = codec.encode('Hello World!')

        assertEquals(expectedResult,primitiveResult)
        assertEquals(expectedResult,toStringResult)

        //make sure encoding null returns null
        assertNull codec.encode(null)
    }

    void testDecode() {
        shouldFail {
            codec.decode [1,2,3,4,5]
        }
    }
}
