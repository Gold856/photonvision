/*
 * MIT License
 *
 * Copyright (c) PhotonVision
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

// THIS FILE WAS AUTO-GENERATED BY ./photon-serde/generate_messages.py. DO NOT MODIFY

package org.photonvision.struct;

import org.photonvision.common.dataflow.structures.Packet;
import org.photonvision.common.dataflow.structures.PacketSerde;
import org.photonvision.utils.PacketUtils;

// Assume that the base class lives here and we can import it
import org.photonvision.targeting.*;

// WPILib imports (if any)
import edu.wpi.first.util.struct.Struct;
import edu.wpi.first.math.geometry.Transform3d;

/**
 * Auto-generated serialization/deserialization helper for PhotonTrackedTarget
 */
public class PhotonTrackedTargetSerde implements PacketSerde<PhotonTrackedTarget> {

    @Override
    public final String getInterfaceUUID() { return "cc6dbb5c5c1e0fa808108019b20863f1"; }
    @Override
    public final String getSchema() { return "float64 yaw;float64 pitch;float64 area;float64 skew;int32 fiducialId;int32 objDetectId;float32 objDetectConf;Transform3d bestCameraToTarget;Transform3d altCameraToTarget;float64 poseAmbiguity;TargetCorner:16f6ac0dedc8eaccb951f4895d9e18b6 minAreaRectCorners[?];TargetCorner:16f6ac0dedc8eaccb951f4895d9e18b6 detectedCorners[?];"; }
    @Override
    public final String getTypeName() { return "PhotonTrackedTarget"; }

    @Override
    public int getMaxByteSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMaxByteSize'");
    }

    @Override
    public void pack(Packet packet, PhotonTrackedTarget value) {
        // field yaw is of intrinsic type float64
        packet.encode((double) value.yaw);

        // field pitch is of intrinsic type float64
        packet.encode((double) value.pitch);

        // field area is of intrinsic type float64
        packet.encode((double) value.area);

        // field skew is of intrinsic type float64
        packet.encode((double) value.skew);

        // field fiducialId is of intrinsic type int32
        packet.encode((int) value.fiducialId);

        // field objDetectId is of intrinsic type int32
        packet.encode((int) value.objDetectId);

        // field objDetectConf is of intrinsic type float32
        packet.encode((float) value.objDetectConf);

        PacketUtils.packTransform3d(packet, value.bestCameraToTarget);

        PacketUtils.packTransform3d(packet, value.altCameraToTarget);

        // field poseAmbiguity is of intrinsic type float64
        packet.encode((double) value.poseAmbiguity);

        // minAreaRectCorners is a custom VLA!
        packet.encodeList(value.minAreaRectCorners);

        // detectedCorners is a custom VLA!
        packet.encodeList(value.detectedCorners);
    }

    @Override
    public PhotonTrackedTarget unpack(Packet packet) {
        var ret = new PhotonTrackedTarget();

        // yaw is of intrinsic type float64
        ret.yaw = packet.decodeDouble();

        // pitch is of intrinsic type float64
        ret.pitch = packet.decodeDouble();

        // area is of intrinsic type float64
        ret.area = packet.decodeDouble();

        // skew is of intrinsic type float64
        ret.skew = packet.decodeDouble();

        // fiducialId is of intrinsic type int32
        ret.fiducialId = packet.decodeInt();

        // objDetectId is of intrinsic type int32
        ret.objDetectId = packet.decodeInt();

        // objDetectConf is of intrinsic type float32
        ret.objDetectConf = packet.decodeFloat();

        ret.bestCameraToTarget = PacketUtils.unpackTransform3d(packet);

        ret.altCameraToTarget = PacketUtils.unpackTransform3d(packet);

        // poseAmbiguity is of intrinsic type float64
        ret.poseAmbiguity = packet.decodeDouble();

        // minAreaRectCorners is a custom VLA!
        ret.minAreaRectCorners = packet.decodeList(TargetCorner.photonStruct);

        // detectedCorners is a custom VLA!
        ret.detectedCorners = packet.decodeList(TargetCorner.photonStruct);

        return ret;
    }

    @Override
    public PacketSerde<?>[] getNestedPhotonMessages() {
        return new PacketSerde<?>[] {
            TargetCorner.photonStruct
        };
    }

    @Override
    public Struct<?>[] getNestedWpilibMessages() {
        return new Struct<?>[] {
            Transform3d.struct
        };
    }
}
