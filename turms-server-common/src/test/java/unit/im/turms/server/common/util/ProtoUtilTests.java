/*
 * Copyright (C) 2019 The Turms Project
 * https://github.com/turms-im/turms
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package unit.im.turms.server.common.util;

import com.google.protobuf.ByteString;
import com.google.protobuf.Int64Value;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.StringValue;
import im.turms.common.model.dto.request.message.CreateMessageRequest;
import im.turms.server.common.util.ProtoUtil;
import io.netty.buffer.ByteBuf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author James Chen
 */
class ProtoUtilTests {

    @Test
    void getDirectByteBuffer_shouldBeParsedToOriginalRequest() throws InvalidProtocolBufferException {
        int messageId = 9999;
        String text = "Test Text";
        byte[] record = new byte[]{1, 2, 3, 4, 10, 11};
        CreateMessageRequest request = CreateMessageRequest
                .newBuilder()
                .setMessageId(Int64Value.newBuilder().setValue(messageId).build())
                .setText(StringValue.newBuilder().setValue(text).build())
                .addRecords(ByteString.copyFrom(record))
                .build();
        ByteBuf buffer = ProtoUtil.getDirectByteBuffer(request);
        CreateMessageRequest parsedRequest = CreateMessageRequest.parseFrom(buffer.nioBuffer());

        assertEquals(request, parsedRequest);
    }

}