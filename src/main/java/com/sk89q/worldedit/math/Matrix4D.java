// $Id$
/*
 * WorldEdit
 * Copyright (C) 2010 sk89q <http://www.sk89q.com> and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.math;

import java.util.Arrays;

public class Matrix4D {
    private final double[] data;

    public Matrix4D() {
        data = new double[16];
    }

    public Matrix4D(double... elements) {
        data = Arrays.copyOf(elements, elements.length);
    }


    public double[] getElements() {
        return data;
    }

    public double getElement(int row, int column) {
        if (row < 0 || row >= 4) {
            throw new IllegalArgumentException("row argument is outside 0..3");
        }

        if (column < 0 || column >= 4) {
            throw new IllegalArgumentException("column argument is outside 0..3");
        }

        return data[row * 4 + column];
    }


    public double determinant() {
        // TODO: find GPL-compatible determinant algo
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Matrix4D inverse() {
        // TODO: find GPL-compatible determinant algo
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Matrix4D transposed() {
        double[] ret = new double[16];

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                ret[i*4 + j] = getElement(j, i);
            }
        }

        return new Matrix4D(ret);
    }

    public Vector4D multiply(Vector4D other) {
        double[] othera = new double[] { other.getX(), other.getY(), other.getZ(), other.getW() };
        double[] ret = new double[4];
        for (int j = 0; j < 4; ++j) {
            ret[j] = 0;
            for (int r = 0; r < 4; ++r) {
                ret[j] += othera[r] * this.getElement(r, j);
            }
        }
        
        return new Vector4D();
    }
}
