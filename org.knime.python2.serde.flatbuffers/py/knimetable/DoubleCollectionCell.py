# automatically generated by the FlatBuffers compiler, do not modify

# namespace: flatc

import flatbuffers

class DoubleCollectionCell(object):
    __slots__ = ['_tab']

    @classmethod
    def GetRootAsDoubleCollectionCell(cls, buf, offset):
        n = flatbuffers.encode.Get(flatbuffers.packer.uoffset, buf, offset)
        x = DoubleCollectionCell()
        x.Init(buf, n + offset)
        return x

    # DoubleCollectionCell
    def Init(self, buf, pos):
        self._tab = flatbuffers.table.Table(buf, pos)

    # DoubleCollectionCell
    def Value(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            a = self._tab.Vector(o)
            return self._tab.Get(flatbuffers.number_types.Float64Flags, a + flatbuffers.number_types.UOffsetTFlags.py_type(j * 8))
        return 0

    # DoubleCollectionCell
    def ValueLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # DoubleCollectionCell
    def Missing(self, j):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        if o != 0:
            a = self._tab.Vector(o)
            return self._tab.Get(flatbuffers.number_types.BoolFlags, a + flatbuffers.number_types.UOffsetTFlags.py_type(j * 1))
        return 0

    # DoubleCollectionCell
    def MissingLength(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        if o != 0:
            return self._tab.VectorLen(o)
        return 0

    # DoubleCollectionCell
    def KeepDummy(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(8))
        if o != 0:
            return self._tab.Get(flatbuffers.number_types.BoolFlags, o + self._tab.Pos)
        return 0

def DoubleCollectionCellStart(builder): builder.StartObject(3)
def DoubleCollectionCellAddValue(builder, value): builder.PrependUOffsetTRelativeSlot(0, flatbuffers.number_types.UOffsetTFlags.py_type(value), 0)
def DoubleCollectionCellStartValueVector(builder, numElems): return builder.StartVector(8, numElems, 8)
def DoubleCollectionCellAddMissing(builder, missing): builder.PrependUOffsetTRelativeSlot(1, flatbuffers.number_types.UOffsetTFlags.py_type(missing), 0)
def DoubleCollectionCellStartMissingVector(builder, numElems): return builder.StartVector(1, numElems, 1)
def DoubleCollectionCellAddKeepDummy(builder, keepDummy): builder.PrependBoolSlot(2, keepDummy, 0)
def DoubleCollectionCellEnd(builder): return builder.EndObject()