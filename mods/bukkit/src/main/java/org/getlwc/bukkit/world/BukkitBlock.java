/**
 * Copyright (c) 2011-2014 Tyler Blair
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ''AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those of the
 * authors and contributors and should not be interpreted as representing official policies,
 * either expressed or implied, of anybody else.
 */
package org.getlwc.bukkit.world;

import org.getlwc.Block;
import org.getlwc.BlockType;
import org.getlwc.SimpleEngine;
import org.getlwc.World;

public class BukkitBlock extends Block {

    /**
     * The bukkit block handle
     */
    private final org.bukkit.block.Block handle;

    /**
     * The world this block is located in
     */
    private World world;

    public BukkitBlock(World world, org.bukkit.block.Block handle) {
        if (handle == null) {
            throw new IllegalArgumentException("Block handle cannot be null");
        }

        this.world = world;
        this.handle = handle;
    }

    @Override
    public BlockType getType() {
        return SimpleEngine.getInstance().getMinecraftRegistry().getLegacyBlockType(handle.getTypeId());
    }

    @Override
    public byte getData() {
        return handle.getData();
    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public int getX() {
        return handle.getX();
    }

    @Override
    public int getY() {
        return handle.getY();
    }

    @Override
    public int getZ() {
        return handle.getZ();
    }

    @Override
    public void setType(BlockType type) {
        handle.setTypeId(type.getLegacyId());
    }

    @Override
    public void setData(byte data) {
        handle.setData(data);
    }

}
